/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author eduar
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private LocalDate dataNasc;
    private String cpf;
    private String celular;
    private String cep;
    private String ocupacao;
    private Connection conexao;

    public Cliente(Connection conexao) {
        this.conexao = conexao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }
    

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
    
    public void inserirCliente() throws SQLException {
        String sql = "insert into Cliente (nome, "
                + "dataNasc, "
                + "cpf, "
                + "celular, "
                + "cep, "
                + "ocupacao) "
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement req = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1, nome);
        req.setString(2, dataNasc.toString());
        req.setString(3, cpf);
        req.setString(4, celular);
        req.setString(5, cep);
        req.setString(6, ocupacao);

        req.execute();

        ResultSet resposta = req.getGeneratedKeys();

        if (resposta.next()) {
            idCliente = resposta.getInt(1);
        }
        
    }
    
}
