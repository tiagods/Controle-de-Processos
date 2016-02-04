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
public class DocumentosIntTermo extends DocumentosIntModelo{
    
    String campo1="TermodeResponsabilidadeDocumento", tabela1="termoderesponsabilidadedocumento", tela1 = "Termo de Responsabilidade Tecnica" ;
    
    public DocumentosIntTermo(){
        setTitle("Senhas/Auorizações - Termo de Responsabilidade Técnica");
        
        super.inicializacao("TermodeResponsabilidadeDocumento","termoderesponsabilidadedocumento", "Termo de Responsabilidade Tecnica");
        
		conexao = new Conexao(); 
        conexao.conecta();
        preencher_tabela();
        pegar_ultimo_registro();
    }
    public static void main(String[] args){
        DocumentosIntModelo doc = new DocumentosIntTermo();
        doc.setVisible(true);
    }
    @Override
    public void enviar_label1(){
        Documentos.lbTermo1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        Documentos.lbTermo2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        Documentos.lbTermo3.setText(data3);
    }
    @Override
    public void atualizaExclusao(){
        doc.termo();
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
