/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eduar
 */
public class Pets {
    
    private int idPet;
    private String tipoDePet;
    private String nome;
    private int idade;
    private String raca;
    private String ultimoDono;
    private String descricao;
    private Connection conexao;
    
    public Pets(Connection conexao) {
        this.conexao = conexao;
    }

    public Pets(int idPet, String tipoDePet, String nome, int idade, String raca, Connection conexao) {
        this.idPet = idPet;
        this.tipoDePet = tipoDePet;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.conexao = conexao;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public String getTipoDePet() {
        return tipoDePet;
    }

    public void setTipoDePet(String tipoDePet) {
        this.tipoDePet = tipoDePet;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getUltimoDono() {
        return ultimoDono;
    }

    public void setUltimoDono(String ultimoDono) {
        this.ultimoDono = ultimoDono;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    
    public void inserirPet() throws SQLException {
        String sql = "insert into pet (tipoDePet, "
                + "nome, "
                + "idade, "
                + "raca, "
                + "ultimoDono, "
                + "descricao) "
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement req = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1, tipoDePet);
        req.setString(2, nome);
        req.setInt(3, idade);
        req.setString(4, raca);
        req.setString(5, ultimoDono);
        req.setString(6, descricao);

        req.execute();

        ResultSet resposta = req.getGeneratedKeys();

        if (resposta.next()) {
            idPet = resposta.getInt(1);
        }
    }
    
    public void deletarPet(int idPet) throws SQLException {
        String sql = "delete from pet where idPet=?";
        PreparedStatement requisicao = this.conexao.prepareStatement(sql);
        requisicao.setInt(1, idPet);
        requisicao.executeUpdate();
    }
    
    public ResultSet listarPets() throws SQLException {
        String sql = "select * from pet;";
        PreparedStatement requisicao = conexao.prepareStatement(sql);
        return requisicao.executeQuery();
    }
    
    public Pets pegarNomeRacaPet(int idPet) throws SQLException {
        String sql = "select tipoDePet,nome,raca from pet where idPet=?;";
        PreparedStatement requisicao = conexao.prepareStatement(sql);
        requisicao.setInt(1, idPet);
        ResultSet data = requisicao.executeQuery();

        while(data.next()) {
            this.tipoDePet = data.getString(1);
            this.nome = data.getString(2);
            this.raca = data.getString(3);
        }
        return this;
    }
    
}
