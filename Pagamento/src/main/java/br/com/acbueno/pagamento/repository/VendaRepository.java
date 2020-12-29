package br.com.acbueno.pagamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.acbueno.pagamento.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
