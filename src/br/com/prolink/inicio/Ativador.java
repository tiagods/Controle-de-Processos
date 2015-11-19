/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prolink.inicio;

import br.com.prolink.inicio.Conexao;
import br.com.prolink.inicio.Conexao;
import java.awt.Component;
import javax.swing.table.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class Ativador extends javax.swing.JFrame {
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    
    Conexao con_cliente, con_organizar;
    
    public static String id;
    public static String nome;
    public static String processo;
    public static String classificacao;
    public static String dataativacao;
    public static String datafinalizacao;
    
    public Ativador() {
        initComponents();
        
        con_cliente = new Conexao();
        con_cliente.conecta();
        
        txt_codigo.setEditable(false);
        
        cb_organizar.setSelectedItem("");
                
        preencher_jtable();
        
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        btnFechar = new javax.swing.JButton();
        txt_apelido = new javax.swing.JTextField();
        lbID = new javax.swing.JLabel();
        btnSelecionar = new javax.swing.JButton();
        lb_organizar = new javax.swing.JLabel();
        cb_organizar = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_ativacao = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ativador");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        lblTitulo.setBackground(new java.awt.Color(245, 245, 245));
        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 22)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Ativação");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        lbCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbCodigo.setText("Cod:");

        lbNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbNome.setText("Nome:");

        btnFechar.setBackground(new java.awt.Color(245, 245, 245));
        btnFechar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFecharMouseClicked(evt);
            }
        });
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        lbID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbID.setText("Apelido:");

        btnSelecionar.setBackground(new java.awt.Color(245, 245, 245));
        btnSelecionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        lb_organizar.setBackground(new java.awt.Color(255, 255, 255));
        lb_organizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_organizar.setText("Organizar por:");

        cb_organizar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cb_organizar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Codigo", "Apelido", "Nome" }));
        cb_organizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_organizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lb_organizar)
                        .addGap(18, 18, 18)
                        .addComponent(cb_organizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addComponent(lbID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbNome)
                        .addGap(18, 18, 18)
                        .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnFechar, btnSelecionar});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbID)
                    .addComponent(txt_apelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnSelecionar)
                    .addComponent(lb_organizar)
                    .addComponent(cb_organizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnFechar, btnSelecionar});

        tb_ativacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Apelido", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_ativacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_ativacaoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_ativacao);
        if (tb_ativacao.getColumnModel().getColumnCount() > 0) {
            tb_ativacao.getColumnModel().getColumn(0).setPreferredWidth(50);
            tb_ativacao.getColumnModel().getColumn(0).setMaxWidth(50);
            tb_ativacao.getColumnModel().getColumn(1).setPreferredWidth(75);
            tb_ativacao.getColumnModel().getColumn(1).setMaxWidth(75);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(534, 438));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFecharMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnFecharMouseClicked

    private void tb_ativacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_ativacaoMouseClicked
        Integer linha =  tb_ativacao.getSelectedRow();
        String codigo = (String)tb_ativacao.getValueAt(linha, 0);
        String apelido = (String)tb_ativacao.getValueAt(linha, 1);
        String nome = (String)tb_ativacao.getValueAt(linha, 2);
        
        txt_codigo.setText(codigo);
        txt_apelido.setText(apelido);
        txt_nome.setText(nome);
    }//GEN-LAST:event_tb_ativacaoMouseClicked

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if(txt_codigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma empresa!");
        }
        else{
            try{
                String sql = "select * from cadastrodeprocesso Where codNumerodoprocesso = "+
                        txt_codigo.getText();
                con_cliente.executeSQL(sql);
                
                if(con_cliente.resultset.first()){
                    
                    processo = con_cliente.resultset.getString("codNumerodoprocesso");
                    id = con_cliente.resultset.getString("Apelido");
                    nome = con_cliente.resultset.getString("Cliente");
                    classificacao = con_cliente.resultset.getString("Classificacao");
                    dataativacao = con_cliente.resultset.getString("DatadeAtivacao");
                    datafinalizacao = con_cliente.resultset.getString("DataDeArquivamentodoProcesso");
                    
                    envia_para_menu();
                    
                    dispose();
                }
            }catch(SQLException erro){
                        JOptionPane.showMessageDialog(null,"Não foi possivel ativar o cliente informado : " +erro);
                        }
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void cb_organizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_organizarActionPerformed
         if(cb_organizar.getSelectedItem().equals("Nome")){
            limpar_tabela();
            preencher_jtable_nome();
        }
        else if(cb_organizar.getSelectedItem().equals("Codigo")){
            limpar_tabela();
            preencher_jtable();
         }
        else if(cb_organizar.getSelectedItem().equals("Apelido")){
            limpar_tabela();
            preencher_jtable_apelido();
        }
    }//GEN-LAST:event_cb_organizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ativador().setVisible(true);
    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JComboBox cb_organizar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lb_organizar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tb_ativacao;
    private javax.swing.JTextField txt_apelido;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_nome;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    public void preencher_jtable(){
        tb_ativacao.getColumnModel().getColumn(0);
        tb_ativacao.getColumnModel().getColumn(1);
        tb_ativacao.getColumnModel().getColumn(2);
        con_cliente.executeSQL("select * from cadastrodeprocesso order by codNumerodoprocesso");
        DefaultTableModel modelo = (DefaultTableModel)tb_ativacao.getModel();
    
        try{
            while(con_cliente.resultset.next())
                modelo.addRow(new Object []{
            con_cliente.resultset.getString("codNumerodoprocesso"),
            con_cliente.resultset.getString("Apelido"),
            con_cliente.resultset.getString("Cliente")});
                con_cliente.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao lista tabela: " +erro);
        }
    }

    /**
     *
     */
    public void preencher_jtable_nome(){
        tb_ativacao.getColumnModel().getColumn(0);
        tb_ativacao.getColumnModel().getColumn(1);
        tb_ativacao.getColumnModel().getColumn(2);
        con_cliente.executeSQL("select * from cadastrodeprocesso order by Cliente");
        DefaultTableModel modelo = (DefaultTableModel)tb_ativacao.getModel();
    
        try{
            while(con_cliente.resultset.next())
                modelo.addRow(new Object []{
            con_cliente.resultset.getString("codNumerodoprocesso"),
            con_cliente.resultset.getString("Apelido"),
            con_cliente.resultset.getString("Cliente")});
                con_cliente.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao lista tabela: " +erro);
        }
    }

    /**
     *
     */
    public void preencher_jtable_apelido(){
        tb_ativacao.getColumnModel().getColumn(0);
        tb_ativacao.getColumnModel().getColumn(1);
        tb_ativacao.getColumnModel().getColumn(2);
        con_cliente.executeSQL("select * from cadastrodeprocesso order by Apelido");
        DefaultTableModel modelo = (DefaultTableModel)tb_ativacao.getModel();
    
        try{
            while(con_cliente.resultset.next())
                modelo.addRow(new Object []{
                    con_cliente.resultset.getString("codNumerodoprocesso"),
                    con_cliente.resultset.getString("Apelido"),
                    con_cliente.resultset.getString("Cliente")});
                    con_cliente.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao lista tabela: " +erro);
        }
    }
    
    public void limpar_tabela(){
    DefaultTableModel tbm = (DefaultTableModel)tb_ativacao.getModel();
        for(int i = tbm.getRowCount()-1; i>=0; i--){
            tbm.removeRow(i);
        }
    }
    public void envia_para_menu(){
        try{
            String datafim="", datainicio="";
            
            TelaPrincipal.txt_codigo.setText(processo);
            TelaPrincipal.txt_id.setText(id);
            TelaPrincipal.txt_nome.setText(nome);
            TelaPrincipal.txt_classificacao.setText(classificacao);
            
            /*if(!dataativacao.equals(datainicio) ){
                String ano = dataativacao.substring(0, 4);
                String mes = dataativacao.substring(5, 7);
                String dia = dataativacao.substring(8);
                datainicio = dia+"/"+mes+"/"+ano;
                
            }
            if(datafinalizacao.length()>9 && datafinalizacao.length()<11){
                String ano = datafinalizacao.substring(0, 4);
                String mes = datafinalizacao.substring(5, 7);
                String dia = datafinalizacao.substring(8);
                
                datafim = dia+"/"+mes+"/"+ano;
            }*/
            
            TelaPrincipal.txt_ativada.setText(dataativacao);
            TelaPrincipal.txt_finalizada.setText(datafinalizacao);
            
            
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Erro ao ativar a empresa!\n"+erro);
        }
    }
}