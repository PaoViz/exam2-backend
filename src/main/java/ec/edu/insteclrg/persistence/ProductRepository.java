package ec.edu.insteclrg.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
