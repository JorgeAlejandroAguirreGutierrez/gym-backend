package com.backend.gym.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.backend.gym.modelos.Cliente;
import com.backend.gym.repositorios.IClienteRepository;

import static com.backend.gym.Constantes.LOGCLASS;
import static com.backend.gym.Constantes.LOGMETHOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
public class ClienteService {
	private static final Logger logger = LoggerFactory.getLogger(ClienteService.class);

    @Autowired
    private IClienteRepository clienteRepository;

    /**
     * Consulta el cliente por id
     * @param id
     * @return Cliente
     */
    public Optional<Cliente> obtener(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final Optional<Cliente> cliente= clienteRepository.findById(id);
        return cliente;
    }
    /**
     * Consulta todos los clientes
     * @return List<Cliente>
     */
    public List<Cliente> consultar() {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
        final List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }
    /**
     * Crea un nuevo cliente
     * @param Cliente
     * @return Cliente 
     */
    public Optional<Cliente> crear(Cliente cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(clienteRepository.save(cliente));
    }
    /**
     * Actualiza un cliente
     * @param Cliente
     * @return Cliente
     */
    public Optional<Cliente> actualizar(Cliente cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return Optional.of(clienteRepository.save(cliente));
    }
    
    /**
     * Elimina un cliente
     * @param id
     */
    public void eliminar(long id) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	clienteRepository.deleteById(id);
    }
    
    /**
     * Consulta todos los clientes
     * @return List<Cliente>
     */
    public List<Cliente> buscar(Cliente cliente) {
    	logger.info(LOGMETHOD+Thread.currentThread().getStackTrace()[1].getMethodName()+LOGCLASS+this.getClass().getSimpleName());
    	return  clienteRepository.findAll(new Specification<Cliente>() {
            @Override
            public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (cliente.getNombre()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nombre"), "%"+cliente.getNombre()+"%")));
                }
                if (cliente.getIdentificacion()!=null) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("identificacion"), "%"+cliente.getIdentificacion()+"%")));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }
}
