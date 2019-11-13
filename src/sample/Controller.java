package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
public class Controller {

    private Operation op;
    private double data;
    private double result;
    @FXML
    private TextField display;

    @FXML private Button zero, one, two, three, four, five, six, seven, eight, nine;
    @FXML private Button clear, equal, plus, minus, divide, multiply;

    @FXML
    public void handleNumberAction(ActionEvent event){
        if(event.getSource() == zero){
            display.setText(display.getText() + "0");
        } else if(event.getSource() == one){
            display.setText(display.getText() + "1");
        } else if(event.getSource() == two){
            display.setText(display.getText() + "2");
        } else if(event.getSource() == three){
            display.setText(display.getText() + "3");
        } else if(event.getSource() == four){
            display.setText(display.getText() + "4");
        } else if(event.getSource() == five) {
            display.setText(display.getText() + "5");
        } else if(event.getSource() == six){
            display.setText(display.getText() + "6");
        } else if(event.getSource() == seven){
            display.setText(display.getText() + "7");
        } else if(event.getSource() == eight){
            display.setText(display.getText() + "8");
        } else if(event.getSource() == nine){
            display.setText(display.getText() + "9");
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event){
        if (event.getSource() == clear){
            display.setText("");
        } else if(event.getSource() == plus){
            try {
                data = Double.parseDouble(display.getText());
            } catch (NumberFormatException e) {
                display.setText("Error.");
            }
            display.setText("");
            op = Operation.ADDITION;
        } else if(event.getSource() == minus){
            data =  Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.SUBRACTION;
        } else if(event.getSource() == divide){
            data =  Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.DIVISION;
        } else if(event.getSource() == multiply){
            data =  Double.parseDouble(display.getText());
            display.setText("");
            op = Operation.MULTIPLICATION;
        } else if (event.getSource() == equal){
            double secondNumber = Double.parseDouble(display.getText());
            if (op == Operation.ADDITION) {
                result = data + secondNumber;
                display.setText(Double.toString(result));
            }
            else if(op == Operation.SUBRACTION) {
                result = data - secondNumber;
                display.setText(Double.toString(result));
            }
            else if(op == Operation.MULTIPLICATION) {
                result = data * secondNumber;
                display.setText(Double.toString(result));
            }
            else if(op == Operation.DIVISION) {
                try {
                    result = data / secondNumber;
                    display.setText(Double.toString(result));
                } catch (Exception e) {
                    display.setText("Error.");
                }
            }
        }

    }

    @FXML
    public void initialize(){
        display.setEditable(false);
    }

}

enum Operation {
    ADDITION, MULTIPLICATION, DIVISION, SUBRACTION
}