package br.com.prolink.recepcao;

import br.com.prolink.inicio.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author Tiago Dias
 */
public class ConfirmarDocumento extends javax.swing.JFrame {
     
    MaskFormatter formatoData1, formatoData2;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    Conexao con_recebidos;
    
    String dataRec_backup, recPor_backup, obs_backup;
    
    public static String codigo;
    String  hora,recebidopor,observacao,id, nome, remetente, historico, para,
            dataconfirmada, usuario = Login.usuario;
    
    public ConfirmarDocumento() {
        initComponents();
        
        con_recebidos = new Conexao();
        con_recebidos.conecta();
        
        
//        receber_listagem();
//        
        if(!txt_recebidopor.getText().trim().equals("")){
            try{
                con_recebidos.executeSQL("select * from documentos_recebidos where cod="+txtCodigo.getText());
                if(con_recebidos.resultset.first()){
                    txt_recebidopor.setText(con_recebidos.resultset.getString("Quem_recebeu"));
                    txt_observacao.setText(con_recebidos.resultset.getString("Observacao"));
                    String novadata  = con_recebidos.resultset.getString("Data_Funcionario_Recebeu");
                    if(novadata.trim().length()==10){
                        String ano = novadata.substring(0, 4);
                        String mes = novadata.substring(5, 7);
                        String dia = novadata.substring(8);
                        
                        txt_recebidoem.setText(dia+"/"+mes+"/"+ano);
                    }
                    
                }
            }catch(Exception erro){
                JOptionPane.showMessageDialog(null, "opa");
            }
        }
        else{
            txt_recebidopor.setText(usuario);
            pegar_datarecebida();
            btnAlterar.setEnabled(false);
        }
        
        bloquear_tela();
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp_Geral = new javax.swing.JPanel();
        lb_codigo = new javax.swing.JLabel();
        lb_remetente = new javax.swing.JLabel();
        lb_idempresa = new javax.swing.JLabel();
        lb_nome = new javax.swing.JLabel();
        lb_destino = new javax.swing.JLabel();
        lb_recebidopor = new javax.swing.JLabel();
        lb_recebidoem = new javax.swing.JLabel();
        lb_resumo = new javax.swing.JLabel();
        txt_remetente = new javax.swing.JTextField();
        txt_idempresa = new javax.swing.JTextField();
        txt_nome = new javax.swing.JTextField();
        txt_recebidopor = new javax.swing.JTextField();
        try {
      formatoData2 = new MaskFormatter("##/##/####");
}catch(Exception erro){
      JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
}
        txt_recebidoem = new JFormattedTextField(formatoData2);
        btnSalvar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_historico = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observacao = new javax.swing.JTextArea();
        lb_observacao = new javax.swing.JLabel();
        txt_para = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lb_data = new javax.swing.JLabel();
        try {       
            formatoData1 = new MaskFormatter("##/##/####");
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null ,"Não foi possivel receber a data" +erro);
        }
        txt_data = new JFormattedTextField(formatoData1);
        txt_hora = new javax.swing.JTextField();
        lbHora = new javax.swing.JLabel();
        btnAlterar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JLabel();
        txt_departamento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmação de Recebimento");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Controle de Documentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addContainerGap())
        );

        jp_Geral.setBackground(new java.awt.Color(255, 255, 255));
        jp_Geral.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lb_codigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_codigo.setText("Código:");
        lb_codigo.setAlignmentY(0.8F);

        lb_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_remetente.setText("Entregue por:");
        lb_remetente.setAlignmentY(0.8F);

        lb_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_idempresa.setText("Empresa ID:");
        lb_idempresa.setAlignmentY(0.8F);

        lb_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_nome.setText("Emp. Nome:");
        lb_nome.setAlignmentY(0.8F);

        lb_destino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_destino.setText("Destino:");
        lb_destino.setAlignmentY(0.8F);

        lb_recebidopor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_recebidopor.setText("Recebido por:");
        lb_recebidopor.setAlignmentY(0.8F);

        lb_recebidoem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_recebidoem.setText("Em:");
        lb_recebidoem.setAlignmentY(0.8F);

        lb_resumo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_resumo.setText("Historico");
        lb_resumo.setAlignmentY(0.8F);

        txt_remetente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_remetente.setAlignmentY(0.8F);

        txt_idempresa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_idempresa.setAlignmentY(0.8F);

        txt_nome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nome.setAlignmentY(0.8F);

        txt_recebidopor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_recebidopor.setAlignmentY(0.8F);

        txt_recebidoem.setAlignmentY(0.8F);

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setAlignmentY(0.8F);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSair.setText("Sair");
        btSair.setAlignmentY(0.8F);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        txt_historico.setColumns(20);
        txt_historico.setLineWrap(true);
        txt_historico.setRows(5);
        jScrollPane2.setViewportView(txt_historico);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setAlignmentY(0.8F);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txt_observacao.setColumns(20);
        txt_observacao.setLineWrap(true);
        txt_observacao.setRows(5);
        jScrollPane1.setViewportView(txt_observacao);

        lb_observacao.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_observacao.setText("Observacao:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Funcionário:");

        lb_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_data.setText("Data:");
        lb_data.setAlignmentY(0.8F);

        txt_data.setAlignmentY(0.8F);
        txt_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbHora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbHora.setText("Hora:");

        btnAlterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setAlignmentY(0.8F);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jp_GeralLayout = new javax.swing.GroupLayout(jp_Geral);
        jp_Geral.setLayout(jp_GeralLayout);
        jp_GeralLayout.setHorizontalGroup(
            jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GeralLayout.createSequentialGroup()
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(lb_remetente))
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_resumo)
                                    .addComponent(lb_destino)
                                    .addComponent(lb_nome)
                                    .addComponent(lb_idempresa)))
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lb_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(txt_para, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_idempresa, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(txt_remetente))
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_data)
                                    .addComponent(lbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_hora, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(txt_data)))))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addComponent(lb_observacao)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addComponent(lb_recebidopor)
                                .addGap(10, 10, 10)
                                .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(lb_recebidoem)
                                .addGap(10, 10, 10)
                                .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp_GeralLayout.setVerticalGroup(
            jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_GeralLayout.createSequentialGroup()
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lb_data))
                            .addComponent(txt_data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp_GeralLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lb_codigo)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_GeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_hora, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHora)
                    .addComponent(txt_remetente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_remetente))
                .addGap(15, 15, 15)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_idempresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_idempresa))
                .addGap(11, 11, 11)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_nome))
                .addGap(10, 10, 10)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lb_destino)
                        .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(txt_para, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_resumo)))
                .addGap(19, 19, 19)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lb_recebidopor))
                    .addComponent(txt_recebidopor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp_GeralLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lb_recebidoem))
                    .addComponent(txt_recebidoem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_observacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp_GeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jp_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(642, 579));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        restaurar_backup();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(txt_recebidoem.getText().trim().length()<10 || txt_recebidoem.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "A data informada esta incorreto valor incorreto!");
        }
        if(txt_observacao.getText().trim().length()<1)
        {
            observacao="";
        }
        else{
            
            try{
                String data2 = txt_recebidoem.getText();
                Date datarec = sdf.parse(data2);

                String sql =  "UPDATE documentos_recebidos set Quem_recebeu='"+txt_recebidopor.getText()+"',"+
                        "Data_Funcionario_Recebeu='"+new java.sql.Date(datarec.getTime())+"',"+
                        "Observacao='"+observacao+"'"+
                        "where cod="+codigo;
                con_recebidos.statement.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            }catch(SQLException erro){
                JOptionPane.showMessageDialog(null,"Erro ao atualizar a tabela de documentos :\n" +erro);
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null,"Falha na conversão da data :\n" +ex);
            }
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        criar_backup();
        String duvida = "Esse documento ja foi recebido por "+recebidopor+"!\n"+
                "Deseja alterar o atual registro?";
        int continuar = JOptionPane.showConfirmDialog(null, duvida, "Informação!", JOptionPane.YES_NO_OPTION);
        if(continuar == JOptionPane.YES_OPTION){
            pegar_datarecebida();
            txt_recebidopor.setText(usuario);
            txt_observacao.setText("");
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    public static void main(String args[]) {
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfirmarDocumento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSair;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jp_Geral;
    private javax.swing.JLabel lbHora;
    private javax.swing.JLabel lb_codigo;
    private javax.swing.JLabel lb_data;
    private javax.swing.JLabel lb_destino;
    private javax.swing.JLabel lb_idempresa;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_observacao;
    private javax.swing.JLabel lb_recebidoem;
    private javax.swing.JLabel lb_recebidopor;
    private javax.swing.JLabel lb_remetente;
    private javax.swing.JLabel lb_resumo;
    public static javax.swing.JLabel txtCodigo;
    public static javax.swing.JFormattedTextField txt_data;
    public static javax.swing.JTextField txt_departamento;
    public static javax.swing.JTextArea txt_historico;
    public static javax.swing.JTextField txt_hora;
    public static javax.swing.JTextField txt_idempresa;
    public static javax.swing.JTextField txt_nome;
    public static javax.swing.JTextArea txt_observacao;
    public static javax.swing.JTextField txt_para;
    public static javax.swing.JFormattedTextField txt_recebidoem;
    public static javax.swing.JTextField txt_recebidopor;
    public static javax.swing.JTextField txt_remetente;
    // End of variables declaration//GEN-END:variables

public void bloquear_tela(){
    txt_data.setEditable(false);
    txt_hora.setEditable(false);
    txt_idempresa.setEditable(false);
    txt_departamento.setEditable(false);
    txt_nome.setEditable(false);
    txt_para.setEditable(false);
    txt_remetente.setEditable(false);
    txt_historico.setEditable(false);
//    txt_remetente.setEditable(false);
//    txt_historico.setEditable(false);
//    txt_recebidopor.setEditable(false);
}
public void criar_backup(){

    dataRec_backup = txt_recebidoem.getText();
    recPor_backup = txt_recebidopor.getText();
    obs_backup = txt_observacao.getText();

}
public void restaurar_backup(){
    
    txt_recebidoem.setText(dataRec_backup);
    txt_recebidopor.setText(recPor_backup);
    txt_observacao.setText(obs_backup);
    
}
//public void receber_listagem(){
//            acertar_data();
//            
//            try{
//                con_recebidos.executeSQL("select * from documentos_recebidos where cod="+codigo);
//                if(con_recebidos.resultset.first()){
//                
//                    data = sdf.format(con_recebidos.resultset.getDate("Data_Recebimento"));
//                    hora = (con_recebidos.resultset.getString("Hora"));
//                    id = (con_recebidos.resultset.getString("ID"));
//                    nome=(con_recebidos.resultset.getString("Empresa"));
//                    remetente=(con_recebidos.resultset.getString("Quem_Entregou"));
//                    historico=(con_recebidos.resultset.getString("Historico"));
//                    para=(con_recebidos.resultset.getString("Para_Quem"));
//                    cb_departamento.setSelectedItem(con_recebidos.resultset.getString("Departamento"));
//                    
//                    recebidopor = con_recebidos.resultset.getString("Quem_recebeu");
//                    observacao = con_recebidos.resultset.getString("Observacao");
//                    dataconfirmada = con_recebidos.resultset.getString("Data_Funcionario_Recebeu");
//                }
//            }catch(Exception erro){
//                JOptionPane.showMessageDialog(null, "Falha ao recuperar registro! \n"+erro+ "\n");
//            }
//            
//}
public void pegar_datarecebida(){
    Date data = new Date();
    String ndata = sdf.format(data);
    
    txt_recebidoem.setText(ndata);
}
}