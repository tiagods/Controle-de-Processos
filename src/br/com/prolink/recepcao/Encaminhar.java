package br.com.prolink.recepcao;

import br.com.prolink.model.HtmlEntities;
import br.com.prolink.factory.ConexaoStatement;
import br.com.prolink.model.UsuarioLogado;
import br.com.prolink.view.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
/*
 * Todos direitos reservados a Tiago Dias de Souza
 * www.github.com/tiagods
 */

/**
 *
 * @author User
 */
public class Encaminhar extends javax.swing.JInternalFrame {
    Connection con;
    Listagem listagem;
            
    public Connection getCon(){
        this.con= new ConexaoStatement().getConnetion();
        return this.con;
    }
    
    public Encaminhar() {
        initComponents();
        setDepartamento("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cb_departamento = new javax.swing.JComboBox<>();
        cb_para = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setTitle("Encaminhar");
        setToolTipText("");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });

        jLabel3.setText("caso contrario, terá que clicar em Contestar");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Não é para você?");

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Se souber a quem pertence informe aqui,");

        cb_departamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cb_departamentoFocusLost(evt);
            }
        });

        cb_para.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cb_paraFocusGained(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cb_para, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_para, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        setBounds(0, 0, 300, 250);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(cb_para.getSelectedItem()!=null && !cb_para.getSelectedItem().equals("")){
            String registro = "Você esta informando que o documento pertence a "+cb_para.getSelectedItem()+"? \nDeseja confirmar?";
            int escolha = JOptionPane.showConfirmDialog(null, registro, "Atenção", JOptionPane.YES_NO_OPTION);
            if(escolha==JOptionPane.YES_OPTION){
                encaminhar();
            }
        }
        else
        JOptionPane.showMessageDialog(null, "Nenhum usuario foi informado! Tente de novo");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cb_departamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_departamentoFocusLost
        cb_para.removeAllItems();
        switch((String)cb_departamento.getSelectedItem()){
            case "":
            setUsuario("");
            break;
            default:
            setUsuario((String)cb_departamento.getSelectedItem());
            break;
        }
    }//GEN-LAST:event_cb_departamentoFocusLost

    private void cb_paraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cb_paraFocusGained
        
    }//GEN-LAST:event_cb_paraFocusGained

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        this.setLocation(0,0);
    }//GEN-LAST:event_formComponentMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_departamento;
    private javax.swing.JComboBox<String> cb_para;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
private void setUsuario(String departamento){
        String sql, dep="";
        if(!departamento.equals(null) && !departamento.equals("")){
            dep = "Departamento='"+departamento+"' and ";
        }
        sql = "select Usuario from login where "+dep+"Ativo=1 order by Usuario";
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    cb_para.addItem(rs.getString("Usuario"));
                }
            }
            con.close();
            
        }catch(SQLException erro){
            
        }
    }
    private void setDepartamento(String usuario){
        String sql;
        if(!usuario.equals("") && !usuario.equals(null)){
            sql = "select A.nome as Nome from departamento as A inner join login as B on A.nome = B.Departamento and B.Usuario like '"+usuario+"'";
        }
        else
            sql="select nome as Nome from departamento";
        try{
            
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    cb_departamento.addItem(rs.getString("Nome"));
                }
            }
            con.close();
        }catch(SQLException erro){
            
        }
    }
    private void encaminhar(){
    String sql = "update documentos_recebidos set Recebido='N', Alerta='N', Departamento=?, Para_Quem=? where cod=?";
    try{
    int codigo=Integer.parseInt(Listagem.txtCodigo.getText());
    
    PreparedStatement ps = getCon().prepareStatement(sql);
    ps.setString(1, (String)cb_departamento.getSelectedItem());
    ps.setString(2, (String)cb_para.getSelectedItem());
    ps.setInt(3, codigo);
    if(ps.executeUpdate()>0){
        AvisoEmail email = new AvisoEmail();
        Date hora = new Date();
        SimpleDateFormat sdh = new SimpleDateFormat("HH:mm");
        String novaHora = sdh.format(hora);
        
        String aux = "Esse documento chegou para "+UsuarioLogado.getInstance().getUsuario().getUsuario()+" mas ele encaminhou para você!";
        String contaEmail = buscarEmail((String)cb_para.getSelectedItem());
        JOptionPane.showMessageDialog(null, "Procedimento concluido!");
        
        if(!contaEmail.equals("")){
            ps = con.prepareStatement("select * from protocolo_item where item_id=?");
            ps.setInt(1, Integer.parseInt(Listagem.txtCodigo.getText()));
            
            List<String> itemNome = new ArrayList<>();
            List<String> qtde = new ArrayList<>();
            List<String> detalhes = new ArrayList<>();
            HtmlEntities conversorHtml = new HtmlEntities();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                itemNome.add(conversorHtml.Converter(rs.getString("item_nome")));
                qtde.add(rs.getString("item_quantidade"));
                detalhes.add(conversorHtml.Converter(rs.getString("item_detalhe")));
            }
            String idEmpresa = Listagem.txtId.getText();
            String novoId = idEmpresa.length()<4?(
                idEmpresa.length()==1?"000"+idEmpresa:(
                    idEmpresa.length()==2?"00"+idEmpresa:"0"+idEmpresa
                )
                ):idEmpresa;
            
            if(email.enviaAlerta(Listagem.txtCodigo.getText(),novoId,conversorHtml.Converter(Listagem.txtEmpresa.getText()),itemNome.iterator(),qtde.iterator(),detalhes.iterator(),(String)cb_para.getSelectedItem(),contaEmail,aux)){
            //if(email.enviaAlerta(aux, novaHora,""+Listagem.txtEmpresa.getText(),""+Listagem.txtId.getText(), contaEmail, ""+cb_para.getSelectedItem(),""+Listagem.txtHistorico.getText())==true){
                atualiza_alerta(codigo);
                ListagemBean lb = new ListagemBean();
                lb.carrega_usuario();
                String comando = lb.getComando();
                listagem.preencher_tabela(comando);
                listagem.limpar_tela();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Erro ao enviar o alerta!");
        con.close();
    }
    }catch(SQLException erro){
        JOptionPane.showMessageDialog(null, "Procedimento não realizado!\n"+erro);
    }
}
    private String buscarEmail(String usuario){
        try{
            String sql = "select Email from login where Usuario like ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    String emailUser = rs.getString("Email");
                    return emailUser;
                    }
            }
            else
                   return "";
            con.close();
         }catch(Exception e){
            System.out.print("Erro ao buscar email do usuario");
            return "";
        }
        return "";
    }
private void atualiza_alerta(int codigo){
    try{
        String sql2 = "update documentos_recebidos set Recebido='N', Alerta='S' where cod=?";
        PreparedStatement ps = getCon().prepareStatement(sql2);
        ps.setInt(1, codigo);
        ps.executeUpdate();
        con.close();
    }catch(Exception e){
        
    }
}
}
