import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CifraController {

    @FXML
    private Button btn_cripto, btn_descripto;
    
    @FXML
    private TextField txt_cripto, txt_chave_cripto, txt_descripto, txt_chave_descripto, txt_resultado;

    @FXML
    void Criptografar(ActionEvent event) {
        ArrayList<Character> abecedario = new ArrayList<Character>();
        ArrayList<Character> textoDesmembrado = new ArrayList<Character>();        
        ArrayList<Character> letraCifrada = new ArrayList<Character>();
        Integer chaveCifra = 0;
        String textoPuro;
        
        textoPuro = txt_cripto.getText().toLowerCase();
        chaveCifra = Integer.valueOf(txt_chave_cripto.getText());
           
        String letrasEncadeadas = "abcdefghijklmnopqrstuvwxyz";
            for(int i=0; i<letrasEncadeadas.length(); i++){
                abecedario.add(i, letrasEncadeadas.charAt(i));
            }
        //--------------------------------------------------------
            
        //Cria o ArrayList do texto digitado----------------------
            for(int i=0; i<textoPuro.length(); i++){
                textoDesmembrado.add(i, textoPuro.charAt(i));
            }
        //--------------------------------------------------------
    
        //Mecanismo de comparacao dos ArrayList Texto e Abecedario
            
            for(int i=0; i<textoDesmembrado.size(); i++){
                if(textoDesmembrado.get(i).equals(' ')){
                    letraCifrada.add(i, textoDesmembrado.get(i));
                }else{
                    for(int j=0; j<abecedario.size(); j++){
                        if(textoDesmembrado.get(i).equals(abecedario.get(j))){
                            if((j + chaveCifra) >= abecedario.size()){
                                Integer aux = ((j-26)+chaveCifra);
                                letraCifrada.add(i, abecedario.get(aux));
                            }else {
                                letraCifrada.add(i, abecedario.get(j+chaveCifra));
                            }
                        }
                    }
                }
            }
            //--------------------------------------------------------------
            
            //Concatenando os Ã­ndices do ArrayList para formar a palavra cifrada em uma String
            StringBuilder textoCriptografado = new StringBuilder();
            for(int i=0; i<letraCifrada.size(); i++){
                textoCriptografado.append(letraCifrada.get(i));
            }
            txt_resultado.setText(textoCriptografado.toString());
        }
    
    

    @FXML
    void Descriptografar(ActionEvent event) {
        ArrayList<Character> abecedario = new ArrayList<Character>();
        ArrayList<Character> textoDesmembrado = new ArrayList<Character>();        
        ArrayList<Character> letraCifrada = new ArrayList<Character>();
        Integer chaveCifra = 0;
        String textoPuro;
        
        textoPuro = txt_descripto.getText().toLowerCase();
        chaveCifra = Integer.valueOf(txt_chave_descripto.getText());
        
        //Cria o ArrayList do abecedario--------------------------
        String letrasEncadeadas = "abcdefghijklmnopqrstuvwxyz";
            for(int i=0; i<letrasEncadeadas.length(); i++){
                abecedario.add(i, letrasEncadeadas.charAt(i));
            }
            //--------------------------------------------------------
            
            //Cria o ArrayList do texto digitado----------------------
            for(int i=0; i<textoPuro.length(); i++){
                textoDesmembrado.add(i, textoPuro.charAt(i));
            }
            //--------------------------------------------------------
    
            //Mecanismo de comparacao dos ArrayList Texto e Abecedario
            
            for(int i=0; i<textoDesmembrado.size(); i++){
                if(textoDesmembrado.get(i).equals(' ')){
                    letraCifrada.add(i, textoDesmembrado.get(i));
                }else{
                    for(int j=0; j<abecedario.size(); j++){
                        if(textoDesmembrado.get(i).equals(abecedario.get(j))){
                            if(j-chaveCifra < 0){
                                Integer aux = ((j+26)-chaveCifra);
                                letraCifrada.add(i, abecedario.get(aux));
                            }else{
                                letraCifrada.add(i, abecedario.get(j-chaveCifra));
                            }
                        }
                    }
                }
            }
            //--------------------------------------------------------------
            
            //Concatenando os Ã­ndices do ArrayList para formar a palavra cifrada em uma String
            StringBuilder textoCriptografado = new StringBuilder();
            for(int i=0; i<letraCifrada.size(); i++){
                textoCriptografado.append(letraCifrada.get(i));
            }
            txt_resultado.setText(textoCriptografado.toString());
        }    
    
    

}
