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
public class DocumentosIntDocumentosSocios extends DocumentosIntModelo{
    
    String campo1="RGeCPFSocio", tabela1="rgecpfsocio", tela1 = "Documentos dos Socios" ;
    
    public DocumentosIntDocumentosSocios(){
        setTitle("Contratos - Documentos dos Socios(RG e CPF)");
        
        super.inicializacao("RGeCPFSocio", "rgecpfsocio", "Documentos dos Socios");
        
	conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
        
        
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntDocumentosSocios();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbDoc1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbDoc2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbDoc3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.docSocios();
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
