
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class TelaVendas extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    private ProdutosDAO produtosDAO;


public TelaVendas() {
        super("Tela de Vendas");

        produtosDAO = new ProdutosDAO();

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); 

        
        table = new JTable();
        scrollPane = new JScrollPane(table);

       
        ArrayList<ProdutosDTO> produtosVendidos = produtosDAO.listarProdutosVendidos();

        
        String[] colunas = {"ID", "Nome", "Valor", "Status"};
        Object[][] dados = new Object[produtosVendidos.size()][4];

        for (int i = 0; i < produtosVendidos.size(); i++) {
            ProdutosDTO produto = produtosVendidos.get(i);
            dados[i][0] = produto.getId();
            dados[i][1] = produto.getNome();
            dados[i][2] = produto.getValor();
            dados[i][3] = produto.getStatus();
        }

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        table.setModel(model);

        
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        
        setVisible(true);
    }

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnConsultarvendas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tela vendas");

        btnConsultarvendas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultarvendas.setText("Consultar Vendas");
        btnConsultarvendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarvendasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultarvendas)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(btnConsultarvendas)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new TelaVendas().setVisible(true);
        });
    }
    




    private void btnConsultarvendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarvendasActionPerformed
      TelaVendas telaVendas = new TelaVendas();
    telaVendas.setVisible(true);

    }//GEN-LAST:event_btnConsultarvendasActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarvendas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
