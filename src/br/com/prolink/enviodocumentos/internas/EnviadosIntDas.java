/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */
package br.com.prolink.enviodocumentos.internas;

import br.com.prolink.model.LogUsuarioBean;
import br.com.prolink.model.LogUsuarioDao;
import br.com.prolink.enviodocumentos.DocumentosEnviados;
import br.com.prolink.enviodocumentos.DocumentosEnviadosDao;
import br.com.prolink.model.ProcessoLogado;
import java.sql.Connection;

/**
 *
 * @author User
 */
public class EnviadosIntDas extends EnviadosIntModelo{
    String campo1="DASacompanhamento", tabela1="dasacompanhamento", tela1 = "Das";
    public EnviadosIntDas(){
        setTitle("Acompanhamento de Envios - Das");
        
        super.inicializacao(campo1, tabela1, tela1);
        
        preencher_tabela();
        pegar_ultimo_registro();
        
        doc = new DocumentosEnviadosDao();
        log = new LogUsuarioDao();
        logb = new LogUsuarioBean();
        
        logb.setCliente(nome);
        logb.setApelido(ProcessoLogado.getInstance().getProcesso().getApelido());
        logb.setProcesso(processo);
        logb.setTela(tela);
    }
    public static void main(String[] args){
        EnviadosIntModelo telaBoletos = new EnviadosIntDas();
        telaBoletos.setVisible(true);
    }
    
    @Override
    public void enviar_label1(){
        DocumentosEnviados.lbDas1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        DocumentosEnviados.lbDas2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        DocumentosEnviados.lbDas3.setText(data3);
    }
    @Override
    public void atualizaExclusao(Connection con){
        doc.das(con);
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
    