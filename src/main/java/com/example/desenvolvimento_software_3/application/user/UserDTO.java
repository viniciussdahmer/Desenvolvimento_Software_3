package com.example.desenvolvimento_software_3.application.user;

import com.example.desenvolvimento_software_3.application.sintoma.SintomaDTO;

import javax.persistence.Column;
import java.util.List;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String cep;
    private String estado;
    private String cidade;
    private String logradouro;
    private String senha;
    private List<SintomaDTO> sintomas;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<SintomaDTO> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<SintomaDTO> sintomas) {
        this.sintomas = sintomas;
    }
}
