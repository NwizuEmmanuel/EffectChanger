/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package effectschanger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.ColorInput;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author HP
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Pane previewPane;
    
    @FXML
    private Text previewText;

    @FXML
    private Label Label;

    @FXML
    private Text Preview;

    @FXML
    private ToggleGroup EffectButtons;
    
    @FXML
    private Rectangle rectangle_pre;
    
    @FXML
    private void resetBtn(ActionEvent event){
        previewText.toFront();
        previewText.setFont(Font.font(55));
        rectangle_pre.setWidth(0);
        rectangle_pre.setHeight(0);
    }
    
    @FXML
    private void dropShadowHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new DropShadow(25, Color.CORAL));
        previewText.toBack();
    }
    
    @FXML
    private void dropBlurHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new BoxBlur(60, 60, 2));
        previewText.toBack();
        previewText.setFont(Font.font(0));
    }
    
    @FXML
    private void dropGaussainBlurHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new GaussianBlur(25));
        previewText.toBack();
    }
    
    @FXML
    private void dropMotionBlurHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new MotionBlur(150, 25));
        previewText.toBack();
    }
    
    @FXML
    private void dropGlowHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Glow(0.567));
        previewText.toBack();
    }
    
    @FXML
    private void dropBloomHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Bloom(0.09));
        previewText.toBack();
    }
    
    ColorInput bottomInput = new ColorInput(0, 0, 100, 50, Color.BLUE);
    ColorInput topInput = new ColorInput(50, 25, 100, 50, Color.AZURE);
    
    @FXML
    private void dropBlendHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Blend(BlendMode.ADD, bottomInput, topInput));
        previewText.toBack();
        previewText.setFont(Font.font(0));
    }
    
    @FXML
    private void dropReflectionHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Reflection(0.2,0.5,0.7,0));
        previewText.toBack();
    }
    
    @FXML
    private void dropSepiaToneHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new SepiaTone(0.50));
        previewText.toBack();
    }
    
    @FXML
    private void dropShadow2Handler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Shadow(BlurType.TWO_PASS_BOX, Color.CORAL, 10));
        previewText.toBack();
    }
    
    @FXML
    private void dropInnerShadowHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new InnerShadow());
        previewText.toBack();
    }
       
    @FXML
    private void dropImageInputHandler(ActionEvent event)throws FileNotFoundException{
         String absoFilePath = "C:\\Users\\HP\\OneDrive\\Documents\\NetBeansProjects\\effectsChanger\\src\\effectschanger\\io.jpg";
        String absoFilePathMain = absoFilePath.replace("\\", "/");
       
     
         File myFile = new File(absoFilePathMain);
    InputStream myImg =new FileInputStream(myFile);
    Image img = new Image(myImg,100, 100, true, true);
    //ImageInput imgInput = new ImageInput(img);

        rectangle_pre.setWidth(0);
        rectangle_pre.setHeight(0);
        previewText.setFill(Paint.valueOf("white"));
        previewText.setEffect(new ImageInput(img));
        previewText.toFront();
    }
    
    @FXML
    private void dropLightingHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Lighting());
        previewText.toBack();
    }
    
    Light.Distant ligDist = new Light.Distant(45.0, 65.0,Color.AQUA);
    
    @FXML
    private void dropLightingDistHandler(ActionEvent event){
        rectangle_pre.setWidth(200);
        rectangle_pre.setHeight(200);
        rectangle_pre.setEffect(new Lighting(ligDist));
        previewText.toBack();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}    
