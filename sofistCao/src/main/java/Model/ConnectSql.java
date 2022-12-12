/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSql {
    private boolean statusConexao;
    private Connection conexao;
    private String mensagemErro;
    private String nomeDriver;
    private String nomeServidor;
    private String portaServidor;
    private String nomeUsuario;
    private String senha;
    private String nomeBanco;
    public ConnectSql(String nomeServidor, String portaServidor, String nomeUsuario, String senha, String nomeBanco){
    this.nomeServidor = nomeServidor;
    this.portaServidor = portaServidor;
    this.nomeUsuario = nomeUsuario;
    this.senha = senha;
    this.nomeBanco = nomeBanco;
    nomeDriver = "com.mysql.cj.jdbc.Driver";
    statusConexao = false;
    mensagemErro = "";
    }

    public String getNomeDriver() {
        return nomeDriver;
    }

    public void setNomeDriver(String nomeDriver) {
        this.nomeDriver = nomeDriver;
    }

    public String getNomeServidor() {
        return nomeServidor;
    }

    public void setNomeServidor(String nomeServidor) {
        this.nomeServidor = nomeServidor;
    }

    public String getPortaServidor() {
        return portaServidor;
    }

    public void setPortaServidor(String portaServidor) {
        this.portaServidor = portaServidor;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatusConexao() {
        return statusConexao;
    }

    public Connection getConexao() {
        return conexao;
    }

    public String getMensagemErro() {
        return mensagemErro;
    }
    
    public void conectarBanco(){
    String url = "jdbc:mysql://"+nomeServidor+":"+portaServidor+"/"+nomeBanco+"?autoReconnect=true&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    try{
        Class.forName(nomeDriver);
        DriverManager.getConnection(url, nomeUsuario, senha);
        conexao = DriverManager.getConnection(url, nomeUsuario, senha);
        statusConexao = true;
    }catch(ClassNotFoundException e){
        mensagemErro+=e;
        statusConexao = false;
    }
    catch(SQLException e){
        mensagemErro+= e;
        statusConexao = false;
    }
    }
}
