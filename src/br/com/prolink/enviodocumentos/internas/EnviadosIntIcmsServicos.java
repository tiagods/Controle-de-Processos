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
public class EnviadosIntIcmsServicos extends EnviadosIntModelo{
    String campo1="ICMSServTomacompanhamento", tabela1="icmsservtomacompanhamento", tela1 = "Icms Serviços";
    public EnviadosIntIcmsServicos(){
        setTitle("Acompanhamento de Envios - Icms Serviços");
        
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
        EnviadosIntModelo telaBoletos = new EnviadosIntIcmsServicos();
        telaBoletos.setVisible(true);
    }
    
    @Override
    public void enviar_label1(){
        DocumentosEnviados.lbIcmsServ1.setText(data1);
    }
    @Override
    public void enviar_label2(){
        DocumentosEnviados.lbIcmsServ2.setText(data2);
    }
    @Override
    public void enviar_label3(){
        DocumentosEnviados.lbIcmsServ3.setText(data3);
    }
    @Override
    public void atualizaExclusao(Connection con){
        doc.icms_servico(con);
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
    