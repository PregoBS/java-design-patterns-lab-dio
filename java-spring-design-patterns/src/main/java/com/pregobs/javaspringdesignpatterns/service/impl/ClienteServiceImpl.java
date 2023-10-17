package com.pregobs.javaspringdesignpatterns.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pregobs.javaspringdesignpatterns.model.Cliente;
import com.pregobs.javaspringdesignpatterns.model.ClienteRepository;
import com.pregobs.javaspringdesignpatterns.model.Endereco;
import com.pregobs.javaspringdesignpatterns.model.EnderecoRepository;
import com.pregobs.javaspringdesignpatterns.service.ClienteService;
import com.pregobs.javaspringdesignpatterns.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()) {
            salvarClienteComCep(cliente);
        }
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void inserir(Cliente cliente) {
        this.salvarClienteComCep(cliente);
    }

    public void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
