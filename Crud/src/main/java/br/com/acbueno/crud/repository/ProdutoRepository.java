package br.com.acbueno.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acbueno.crud.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
