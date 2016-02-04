/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.documentos.internas;

import br.com.prolink.documentos.Documentos;
import br.com.prolink.inicio.Conexao;

/**
 *
 * @author Tiago
 */
public class DocumentosIntNumeroPis extends DocumentosIntModelo{
    
    String campo1="NumeroPis", tabela1="numeropis", tela1="Numero Pis";
    
    public DocumentosIntNumeroPis(){
        setTitle("Contratos - Numero do Pis");
        
        super.inicializacao("NumeroPIS","numeropis", "Numero Pis");
        
		conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntNumeroPis();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbPis1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbPis2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbPis3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.pisSocio();
    }
    @Override
    public void setTabela(){
        this.tabela=this.tabela1;
    }
    @Override
    public void setCampoDocumentos(){
        this.campoDocumentos = this.campo1;
    }
    @Override
    public void setTela(){
        this.tela = this.tela1;
    }
}
