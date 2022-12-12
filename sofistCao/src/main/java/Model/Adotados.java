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
public class Adotados {
    private int idAdotados;
    private String nomeDoPet;
    private String RacaDoPet;
    private String tipoDoPet;
    private int idCliente;
    private String dataAdocao;
    private Connection conexao;

    public Adotados(Connection conexao) {
        this.conexao = conexao;
    }
    
    public int getIdAdotados() {
        return idAdotados;
    }

    public void setIdAdotados(int idAdotados) {
        this.idAdotados = idAdotados;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
     
    public String getNomeDoPet() {
        return nomeDoPet;
    }

    public void setNomeDoPet(String nomeDoPet) {
        this.nomeDoPet = nomeDoPet;
    }

    public String getRacaDoPet() {
        return RacaDoPet;
    }

    public void setRacaDoPet(String RacaDoPet) {
        this.RacaDoPet = RacaDoPet;
    }

    public String getTipoDoPet() {
        return tipoDoPet;
    }

    public void setTipoDoPet(String tipoDoPet) {
        this.tipoDoPet = tipoDoPet;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(String dataAdocao) {
        this.dataAdocao = dataAdocao;
    }
    
    public void inserirPetAdotado() throws SQLException {
        String sql = "insert into Adotados (nomeDoPet, "
                + "RacaDoPet, "
                + "tipoDoPet, "
                + "idCliente, "
                + "dataAdocao) "
                + " values (?, ?, ?, ?, ?)";

        PreparedStatement req = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        req.setString(1, nomeDoPet);
        req.setString(2, RacaDoPet);
        req.setString(3, tipoDoPet);
        req.setInt(4, idCliente);
        req.setString(5, dataAdocao);

        req.execute();

        ResultSet resposta = req.getGeneratedKeys();

        if (resposta.next()) {
            idAdotados = resposta.getInt(1);
        }
        
    }
    
}
