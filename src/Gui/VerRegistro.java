/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Controlador.*;
import Logica.*;
import java.util.Vector;

/**
 *
 * @author ennuikibun
 */
public class VerRegistro extends javax.swing.JFrame {

    Vista_Control vista_control;
    Persona_Control persona_control;
    Paciente_Control paciente_control;
    Historia_Control historia_control;
    Registro_Control registro_control;
    Causa_Control causa_control;
    AsignaCama_Control asignaCama_control;
    Formulacion_Control formulacion_control;
    CausaConsulta_Control causaConsulta_control;
    Medicamento_Control medicamento_control;
    int mipaciente;
    int mihistoria;
    int miregistro;
    
    public VerRegistro() {
        super("Historia Clínica || Registro de Historia Clínica");
        initComponents();
           
        setLocationRelativeTo(null);
	setSize(692, 632);
	setResizable(false);	
	setVisible(true);
        
        persona_control = new Persona_Control();
        paciente_control = new Paciente_Control();
        historia_control = new Historia_Control();
        registro_control = new Registro_Control();
        causa_control = new Causa_Control();
        asignaCama_control = new AsignaCama_Control();
        formulacion_control = new Formulacion_Control();
        causaConsulta_control = new CausaConsulta_Control();
        medicamento_control = new Medicamento_Control();
        
        mipaciente = 0;
        mihistoria = 0;
        miregistro = 0;
       
    }

    public void setMipaciente(int mipaciente) {
        this.mipaciente = mipaciente;
    }

    public void setMihistoria(int mihistoria) {
        this.mihistoria = mihistoria;
    }

    public void setMiregistro(int miregistro) {
        this.miregistro = miregistro;
    }

    public int getMipaciente() {
        return mipaciente;
    }

    public int getMihistoria() {
        return mihistoria;
    }

    public int getMiregistro() {
        return miregistro;
    }
    
    
    
    public void llenarRegistro(){
        Persona persona = new Persona();
        Paciente paciente = new Paciente();
        Historia_Clinica historia = new Historia_Clinica();
        Registro_Consulta registro = new Registro_Consulta();
           
        persona = persona_control.consultarPersona(mipaciente);
        paciente = paciente_control.consultarPaciente(mipaciente);
        historia = historia_control.consultarHistoria(mipaciente);
        registro = registro_control.consultarRegistro(mihistoria, miregistro);
        String medico = persona_control.consultarPersona(registro.getMedico()).getNombre();
        
        Vector <Causa_Consulta> causas = new Vector <Causa_Consulta>();
        Vector <Formulacion> medicamentos = new Vector <Formulacion>();
        String miscausas = "";
        String mismedicamentos = "";
        id_text.setText(String.valueOf(mipaciente));
        paciente_text.setText(persona.getNombre());
        fechaNaci_text.setText(paciente.getFechaNacimiento());
        numHist_text.setText(String.valueOf(mihistoria));
        numRegi_text.setText(String.valueOf(miregistro));
        fecha_text.setText(registro.getFechaConsulta());
        medico_text.setText(medico);
        Asignacion_Camas asignacion = new Asignacion_Camas();
        asignacion = asignaCama_control.consultarAsignacion(mipaciente, registro.getFechaConsulta());
        if(asignacion != null){
            AsigCama_text.setText("Si");
            numCama_text.setText(String.valueOf(asignacion.getCama()));
        }else
            AsigCama_text.setText("No");     
        causas = causaConsulta_control.listarCausasConsulta(miregistro);
        if(!causas.isEmpty()){
            
            for(int i=0; i<causas.size();i++){
                String nom = causa_control.consultarCausa(causas.get(i).getCausa()).getNombre();
                String descrip = causa_control.consultarCausa(causas.get(i).getCausa()).getDescripcion();
                if(i!=causas.size()-1)
                    miscausas += nom+" ("+descrip+"), ";
                else
                    miscausas += nom+" ("+descrip+"). ";
            }
        }
        causas_area.setText(miscausas);
        int cod_formula = registro_control.consultarRegistro(mihistoria, miregistro).getCodFormulaConsulta();
        medicamentos = formulacion_control.consultarFormulacion(cod_formula);
        if(!medicamentos.isEmpty()){
            for(int i=0; i<medicamentos.size();i++){
                mismedicamentos += medicamento_control.consultarMedicamento(medicamentos.get(i).getCodMedicamento()).getNomMedicamento()+", ";
            }
        }
        medicamentos_area.setText(mismedicamentos);  
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
        numHist_label = new javax.swing.JLabel();
        numReg_label = new javax.swing.JLabel();
        nom_label = new javax.swing.JLabel();
        nacimi_label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        fecha_label = new javax.swing.JLabel();
        medico_label = new javax.swing.JLabel();
        asig_label = new javax.swing.JLabel();
        numCama_label = new javax.swing.JLabel();
        causas_label = new javax.swing.JLabel();
        medicamentos_label = new javax.swing.JLabel();
        causas_Scroll = new javax.swing.JScrollPane();
        causas_area = new javax.swing.JTextArea();
        medica_scroll = new javax.swing.JScrollPane();
        medicamentos_area = new javax.swing.JTextArea();
        id_text = new javax.swing.JLabel();
        paciente_text = new javax.swing.JLabel();
        fechaNaci_text = new javax.swing.JLabel();
        numHist_text = new javax.swing.JLabel();
        numRegi_text = new javax.swing.JLabel();
        fecha_text = new javax.swing.JLabel();
        medico_text = new javax.swing.JLabel();
        numCama_text = new javax.swing.JLabel();
        AsigCama_text = new javax.swing.JLabel();
        horiz_separator1 = new javax.swing.JSeparator();
        horiz_separator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        numHist_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        numHist_label.setText("Historia Clínica No.");

        numReg_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        numReg_label.setText("Registro No.");

        nom_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        nom_label.setText("Nombre Paciente:");

        nacimi_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        nacimi_label.setText("Fecha de Nacimiento:");

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel5.setText("CLÍNICA X");

        id_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        id_label.setText("Id Paciente:");

        fecha_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        fecha_label.setText("Fecha de Consulta:");

        medico_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        medico_label.setText("Médico:");

        asig_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        asig_label.setText("Asignación de Cama:");

        numCama_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        numCama_label.setText("No. Cama:");

        causas_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        causas_label.setText("Causas");

        medicamentos_label.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        medicamentos_label.setText("Medicamentos");

        causas_area.setEditable(false);
        causas_area.setColumns(20);
        causas_area.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        causas_area.setRows(5);
        causas_Scroll.setViewportView(causas_area);

        medicamentos_area.setEditable(false);
        medicamentos_area.setColumns(20);
        medicamentos_area.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        medicamentos_area.setRows(5);
        medica_scroll.setViewportView(medicamentos_area);

        id_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        id_text.setText("id");

        paciente_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        paciente_text.setText("nombre");

        fechaNaci_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        fechaNaci_text.setText("dia/mes/año");

        numHist_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        numHist_text.setText("numero");

        numRegi_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        numRegi_text.setText("numero");

        fecha_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        fecha_text.setText("dia/mes/año");

        medico_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        medico_text.setText("medico");

        numCama_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        numCama_text.setText("000");

        AsigCama_text.setFont(new java.awt.Font("Lucida Bright", 0, 15)); // NOI18N
        AsigCama_text.setText("si/no");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(asig_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AsigCama_text)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numCama_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numCama_text)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(medica_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(causas_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(medicamentos_label)
                                    .addComponent(causas_label)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(numReg_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(numRegi_text))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(id_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(id_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(nom_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(paciente_text, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nacimi_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fechaNaci_text)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(numHist_label)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(numHist_text, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fecha_label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_text)
                                .addGap(100, 100, 100)
                                .addComponent(medico_label)
                                .addGap(24, 24, 24)
                                .addComponent(medico_text, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(horiz_separator1)
            .addComponent(horiz_separator2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_label)
                    .addComponent(nom_label)
                    .addComponent(id_text)
                    .addComponent(paciente_text))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numHist_label)
                    .addComponent(nacimi_label)
                    .addComponent(fechaNaci_text)
                    .addComponent(numHist_text))
                .addGap(18, 18, 18)
                .addComponent(horiz_separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numReg_label)
                    .addComponent(numRegi_text))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha_label)
                    .addComponent(medico_label)
                    .addComponent(fecha_text)
                    .addComponent(medico_text))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asig_label)
                    .addComponent(numCama_label)
                    .addComponent(numCama_text)
                    .addComponent(AsigCama_text))
                .addGap(20, 20, 20)
                .addComponent(horiz_separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(causas_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(causas_Scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(medicamentos_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(medica_scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AsigCama_text;
    private javax.swing.JLabel asig_label;
    private javax.swing.JScrollPane causas_Scroll;
    private javax.swing.JTextArea causas_area;
    private javax.swing.JLabel causas_label;
    private javax.swing.JLabel fechaNaci_text;
    private javax.swing.JLabel fecha_label;
    private javax.swing.JLabel fecha_text;
    private javax.swing.JSeparator horiz_separator1;
    private javax.swing.JSeparator horiz_separator2;
    private javax.swing.JLabel id_label;
    private javax.swing.JLabel id_text;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane medica_scroll;
    private javax.swing.JTextArea medicamentos_area;
    private javax.swing.JLabel medicamentos_label;
    private javax.swing.JLabel medico_label;
    private javax.swing.JLabel medico_text;
    private javax.swing.JLabel nacimi_label;
    private javax.swing.JLabel nom_label;
    private javax.swing.JLabel numCama_label;
    private javax.swing.JLabel numCama_text;
    private javax.swing.JLabel numHist_label;
    private javax.swing.JLabel numHist_text;
    private javax.swing.JLabel numReg_label;
    private javax.swing.JLabel numRegi_text;
    private javax.swing.JLabel paciente_text;
    // End of variables declaration//GEN-END:variables
}
