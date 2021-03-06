/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Abdelhamid Amer Mehali
 */
public class Compilation extends javax.swing.JFrame {
    File file ;
    ArrayList lineList=new ArrayList();
    ArrayList tokensList=new ArrayList();
    ArrayList stlineList=new ArrayList();
    String code;
    private IdTchek id =new IdTchek();
    /**
     * Creates new form Compilation
     */
    public Compilation() {
        initComponents();
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
        ajoute = new javax.swing.JButton();
        lexical = new javax.swing.JButton();
        syntaxe = new javax.swing.JButton();
        semantique = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ajoute.setText("Ajouter le fichier .compila");
        ajoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouteActionPerformed(evt);
            }
        });

        lexical.setText("Analyse Lexical");
        lexical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lexicalActionPerformed(evt);
            }
        });

        syntaxe.setText("Analyse Syntaxique");
        syntaxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syntaxeActionPerformed(evt);
            }
        });

        semantique.setText("Analyse Semantique");
        semantique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semantiqueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoute)
                .addGap(55, 55, 55)
                .addComponent(lexical)
                .addGap(55, 55, 55)
                .addComponent(syntaxe)
                .addGap(55, 55, 55)
                .addComponent(semantique)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semantique, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(syntaxe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lexical, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ajoute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        area.setColumns(30);
        area.setRows(10);
        jScrollPane1.setViewportView(area);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouteActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Fichier Compila", "compila");
	 
        fileChooser.setDialogTitle("Choose a file");
        fileChooser.setFileFilter(filter);
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            //get the file
            file = fileChooser.getSelectedFile();
	}
        
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
        }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
                stringBuffer.append("\n");
                lineList.add(line);//list of lines
            }
        } catch (IOException ex) {
            Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(Compilation.class.getName()).log(Level.SEVERE, null, ex);
        }
            code=stringBuffer.toString();//the code
       area.setText(code);
    }//GEN-LAST:event_ajouteActionPerformed

    private void lexicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lexicalActionPerformed
        String tokensprinter="";
        StringTokenizer st = new StringTokenizer(code);
        
        while (st.hasMoreTokens())
            tokensList.add(st.nextToken());
        for(int i=0 ;i<tokensList.size() ; i++){
            
            if(tokensList.get(i).equals("Start_Program") || tokensList.get(i).equals("start_Program")) 
                tokensprinter=tokensList.get(i)+" : Mot résevé pour le debut de program\n";
            else if(tokensList.get(i).equals("End_Program")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot réservé pour la fin de program\n";
            else if(tokensList.get(i).equals("Int_Number")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour la declaration d'un entier\n";
            else if(tokensList.get(i).equals(",")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : C'est une virgule\n";
            else if(tokensList.get(i).equals("Real_Number")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour la declaration d'un réel\n";
            else if(tokensList.get(i).equals(";;")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour la fin de l'instruction\n";
            else if(tokensList.get(i).equals("Give")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour l'initialisation\n";
            else if(tokensList.get(i).equals("If")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour une condition\n";
            else if(tokensList.get(i).equals("Else")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour la 2ème codition\n";
            else if(tokensList.get(i).equals("<")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Operateur Inferieur\n";
            else if(tokensList.get(i).equals(">")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Operateur Superieur\n";
            else if(tokensList.get(i).equals("--")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Debut ou fin de la codition\n";
            else if(tokensList.get(i).equals("Start")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot réservé pour un debut de block\n";
            else if(tokensList.get(i).equals("Finish")) 
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour un fin de block\n";
            else if(tokensList.get(i).equals("ShowMes"))
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot réservé pour l'affichage\n";
            else if(tokensList.get(i).equals("//."))
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour un commentaire\n";
            else if(tokensList.get(i).equals("Affect"))
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour l'affectation\n";
            else if(isNumeric((String)tokensList.get(i))==true)
                tokensprinter=tokensprinter+tokensList.get(i)+" : Mot resevé pour un nombre\n";
            else if(tokensList.get(i).equals("\""))
                tokensprinter=tokensprinter+tokensList.get(i)+" : Debut ou fin d'un message\n";
            else if(id.tchekID((String)tokensList.get(i))==1)
                tokensprinter=tokensprinter+tokensList.get(i)+" : Identificateur\n";
        }
        area.setText(tokensprinter);
    }//GEN-LAST:event_lexicalActionPerformed

    private void syntaxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syntaxeActionPerformed
        String syntaxprinter="";
        StringTokenizer stemp;
        int bool=0;
        boolean enter=false;
        //----------------------------------------------------start du program
        if(lineList.get(0).equals("Start_Program") || lineList.get(0).equals("Start_Program")) {
            syntaxprinter=syntaxprinter+lineList.get(0)+" : Démarrage valide\n";
            enter=true;
        } else syntaxprinter=syntaxprinter+"Démarrage non valide\n";
        //----------------------------------------------------------------------
        
            for(int i=1 ;i<lineList.size() && enter==true;i++){
                //stlineList.clear();
                stemp = new StringTokenizer((String) lineList.get(i));
            
                while (stemp.hasMoreTokens())
                    stlineList.add(stemp.nextToken());
                
             //--------------------------------------------------   
                if(stlineList.get(0).equals("Int_Number") || stlineList.get(0).equals("Real_Number")){
                    for(int j=1 ;j<stlineList.size() ;j++){
                        if(stlineList.get(j).equals(";;")){
                            //bool=1;
                            break;
                        }
                        else if(id.tchekID((String) stlineList.get(j))==1){
                             bool=1;
                        }
                        else if(stlineList.get(j).equals(","));
                        else {bool=0;break;}
                        
                        if(!stlineList.get(stlineList.size()-1).equals(";;"))bool=0;
                        
                    }
                    if(stlineList.get(1).equals(","))bool=0;
                    if(stlineList.get(1).equals(":"))bool=1;

                    
                    if(bool==1)syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                    else if(bool==0) syntaxprinter=syntaxprinter+"Non valide verifiez votre syntaxe.";
                }
             //---------------------------------------------------
                if(stlineList.get(0).equals("Affect")){
                    if(id.tchekID((String) stlineList.get(1))==1){
                        if(stlineList.get(2).equals("to")){
                            if(id.tchekID((String) stlineList.get(3))==1){
                                if(stlineList.get(4).equals(";;")){
                                    syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                                }else syntaxprinter=syntaxprinter+" : Il manque une ;;";
                            }else syntaxprinter=syntaxprinter+" : 2eme id non valide"; 
                        }else syntaxprinter=syntaxprinter+" : Il manque \":\" ";
                    }else syntaxprinter=syntaxprinter+" : 1er id non valide";  
                }
             //----------------------------------------------------- 
                if(stlineList.get(0).equals("ShowMes")){
                    
                    if(stlineList.get(1).equals(":")){
                        if(stlineList.get(stlineList.size()-2).equals("\"")){
                            
                            if(stlineList.get(stlineList.size()-1).equals(";;")){
                                syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                            }else syntaxprinter=syntaxprinter+" : Il manque une ;;";
                        }else syntaxprinter=syntaxprinter+" : Il manque  une \"";
                    }
                    
                    else if (id.tchekID((String) stlineList.get(1))==1){
                        if(stlineList.get(stlineList.size()-1).equals(";;")){
                                syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                            }else syntaxprinter=syntaxprinter+" : Il manque une ;;";
                    }
                    else syntaxprinter=syntaxprinter+"Non valide verifiez votre syntaxe";
                }
                
                
                if(stlineList.get(0).equals("ShowVal")){
                    if(stlineList.get(1).equals(":")){
                        if(stlineList.get(stlineList.size()-1).equals(";;")){
                            syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                        }else syntaxprinter=syntaxprinter+" : Il manque une ;;";
                    }
                }
              //----------------------------------------------------------- 
                if(stlineList.get(0).equals("//.")){
                    bool=1;
                    syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                }
              //---------------------------------------------------------if
                if(stlineList.get(0).equals("If") || stlineList.get(0).equals("if")){
                    if(stlineList.get(1).equals("--")){
                        if(id.tchekID((String) stlineList.get(2))==1){
                           // if(stlineList.get(3).equals(">") || stlineList.get(3).equals("<")){
                                if(id.tchekID((String) stlineList.get(4))==1){
                                    if(stlineList.get(5).equals("--")){
                                    }
                                    else syntaxprinter=syntaxprinter+"Il manque le 2eme --\n";
                                }
                                else syntaxprinter=syntaxprinter+"Il manque le 2eme id ou il est non valide\n";
                           // }
                            //else syntaxprinter=syntaxprinter+"no <>\n";
                        }
                        else syntaxprinter=syntaxprinter+"Il manque le 1er id ou il est non valide\n";
                    }  
                    else syntaxprinter=syntaxprinter+"Il manque le 1er --\n";  
                    
                    if(bool==1)syntaxprinter=syntaxprinter+lineList.get(i)+" : valide";
                    else if(bool==0) syntaxprinter=syntaxprinter+"Non valide verifiez votre syntaxe";
                }
               //-------------------------------------------------------Set
                if(stlineList.get(0).equals("Give")){
                    if(id.tchekID((String) stlineList.get(1))==1){
                        if(stlineList.get(2).equals(":")){
                            if(isNumeric((String) stlineList.get(3))==true){
                                if(stlineList.get(4).equals(";;")){
                                    syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                                }else bool=0;  
                            }    
                            else syntaxprinter=syntaxprinter+" : Il manque une ;;";  
                        }else syntaxprinter=syntaxprinter+" : Il manque les : ";  
                    }else syntaxprinter=syntaxprinter+" : Id non valide";  
                }
               //------------------------------------------------------- Else Start Finish
                if(stlineList.get(0).equals("Else") || stlineList.get(0).equals("Start") || stlineList.get(0).equals("Finish")){
                    bool=1;
                    syntaxprinter=syntaxprinter+lineList.get(i)+" : Valide";
                }
                //-------------------------------------------------------------videz la list des linetokens
                syntaxprinter=syntaxprinter+"\n";
                stlineList.clear();
            }
            if(VerifBlock(code)==false)syntaxprinter=syntaxprinter+" il manque une 'Start' ou 'Finish'" ;
            //--------------------------------------------------closing
            if(lineList.get(lineList.size()-1).equals("End_Program")) {
            syntaxprinter=syntaxprinter+lineList.get(lineList.size()-1)+" : Fermeture valide\n";
            enter=true;
        } else syntaxprinter=syntaxprinter+"Fermeture non valide\n";
        stlineList.clear();             
        area.setText(syntaxprinter);
    
    }//GEN-LAST:event_syntaxeActionPerformed

    private void semantiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semantiqueActionPerformed
        String traductionprinter="";
        StringTokenizer stemp; 
        ArrayList srLineToJava=new ArrayList();
        
        for(int i=1; i<lineList.size() ;i++){
            stemp = new StringTokenizer((String) lineList.get(i));
            
            while (stemp.hasMoreTokens())
                srLineToJava.add(stemp.nextToken());   
            
            if(srLineToJava.get(0).equals("Int_Number")){
                traductionprinter=traductionprinter+"int ";
                for(int j=1 ;j<srLineToJava.size()-1;j++)
                traductionprinter=traductionprinter+srLineToJava.get(j);
                traductionprinter=traductionprinter+";\n";
            }
            if(srLineToJava.get(0).equals("Real_Number")){
                traductionprinter=traductionprinter+"float ";
                for(int j=1 ;j<srLineToJava.size()-1;j++)
                traductionprinter=traductionprinter+srLineToJava.get(j);
                traductionprinter=traductionprinter+";\n";
            }
            if(srLineToJava.get(0).equals("Affect"))
                traductionprinter=traductionprinter+srLineToJava.get(1)+" = "+srLineToJava.get(2)+";"+"\n";
            if(srLineToJava.get(0).equals("If")||srLineToJava.get(0).equals("if"))
                traductionprinter=traductionprinter+"if("+srLineToJava.get(2)+srLineToJava.get(3)+srLineToJava.get(4)+")\n";
            if(srLineToJava.get(0).equals("Else"))
                traductionprinter=traductionprinter+"else"+"\n";
            if(srLineToJava.get(0).equals("Start"))
                traductionprinter=traductionprinter+"{"+"\n";
            if(srLineToJava.get(0).equals("Finish"))
                traductionprinter=traductionprinter+"}"+"\n";
            if(srLineToJava.get(0).equals("Give"))
                traductionprinter=traductionprinter+srLineToJava.get(1)+" = "+srLineToJava.get(3)+";"+"\n";
            if(srLineToJava.get(0).equals("ShowMes") || srLineToJava.get(0).equals("ShowVal")){
                if(srLineToJava.get(1).equals("\"")){
                    traductionprinter=traductionprinter+"System.out.print(\"";
                    for(int j=4 ;j<srLineToJava.size()-2 ;j++)
                        traductionprinter=traductionprinter+" "+srLineToJava.get(j);
                    traductionprinter=traductionprinter+"\");";
                }
                else{
                    traductionprinter=traductionprinter+"System.out.print(";
                    traductionprinter=traductionprinter+srLineToJava.get(2)+");";
                }
                traductionprinter=traductionprinter+"\n";
            }
            
            
        srLineToJava.clear();
        }
        area.setText(traductionprinter);
    }//GEN-LAST:event_semantiqueActionPerformed
    public static boolean isNumeric(String str){  
        try{   
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe){  
            return false;  
        }  
        return true;  
    }
    public boolean VerifBlock(String codeTokens){
        ArrayList blockList=new ArrayList();
        StringTokenizer st=new StringTokenizer(codeTokens);
        int start=0,finish=0;
        while (st.hasMoreTokens())blockList.add(st.nextToken());
        for(int i=0; i<blockList.size() ;i++){
            if(blockList.get(i).equals("Start")) start++;
            if(blockList.get(i).equals("Finish")) finish++;
        }
        if(start==finish) return true;
        else return false;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Compilation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajoute;
    private javax.swing.JTextArea area;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lexical;
    private javax.swing.JButton semantique;
    private javax.swing.JButton syntaxe;
    // End of variables declaration//GEN-END:variables
}
