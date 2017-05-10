package sample.common;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.picketlink.idm.IdentityManager;
import org.picketlink.idm.PartitionManager;
import org.picketlink.idm.RelationshipManager;
import org.picketlink.idm.credential.Password;
import org.picketlink.idm.model.basic.Grant;
import org.picketlink.idm.model.basic.Role;
import org.picketlink.idm.model.basic.User;

@Singleton
@Startup
public class SecurityInitializer {

    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void create() {

        User user = new User("jane");

        user.setEmail("jane@doe.com");
        user.setFirstName("Jane");
        user.setLastName("Doe");

        IdentityManager identityManager = this.partitionManager.createIdentityManager();

        identityManager.add(user);
        identityManager.updateCredential(user, new Password("123qwe"));
        
        Role userRole = new Role("user");
		identityManager.add(userRole);
        
		
		RelationshipManager relationShipManager = this.partitionManager.createRelationshipManager();
		relationShipManager.add(new Grant(user, userRole));
    }
}
