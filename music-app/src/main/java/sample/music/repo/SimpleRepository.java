package sample.music.repo;

import java.util.List;

import sample.common.MonitoredCDIBean;

interface SimpleRepository<E> {

	List<E> findAll(String loadgraph);

	List<E> findAll();

	E findById(Integer id);

	E findById(Integer id, String loadgraph);

}