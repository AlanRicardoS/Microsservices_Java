package com.alan.crud.controller;

import com.alan.crud.data.vo.ProdutoVO;
import com.alan.crud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final PagedResourcesAssembler<ProdutoVO> assembler;

    @Autowired
    public ProdutoController(ProdutoService produtoService, PagedResourcesAssembler<ProdutoVO> assembler) {
        this.produtoService = produtoService;
        this.assembler = assembler;
    }
    @GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
    public ProdutoVO findById(@PathVariable("id") Long id){
        ProdutoVO produtoVO = produtoService.findById(id);
        produtoVO
    }
}
