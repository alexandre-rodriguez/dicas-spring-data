package br.com.apr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import br.com.apr.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	@EntityGraph(value = "graph.Order.items", type = EntityGraphType.LOAD)
	List<Order> findByOrderNumber(String orderNumber);
	
	@Procedure(name = "calculate")
	Double calculateOrderValue(Double x, Double y);
	
}
