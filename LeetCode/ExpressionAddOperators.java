import java.util.*;

public class ExpressionAddOperators{

    public List<String> addOperators(String num, int target) {

        ArrayList<String> res = new ArrayList<String>();

        addOperatorsHelper(num, 0, target, "", 0, 0, res);

        return res;
    }

    public void addOperatorsHelper(String num, int pos, int target, String path, long value, long lastOptValue, ArrayList<String> res){
        if(pos == num.length()){
            if(value == target){
                res.add(path);
            }
            return;
        }

        for(int i = pos; i<num.length(); i++){
            if(i != pos && num.charAt(pos) == '0'){
                break;
            }
            String currentNumber = num.substring(pos, i+1);
            long currentValue = Long.parseLong(currentNumber);

            if(pos == 0){
                addOperatorsHelper(num, i+1, target, currentValue+"", currentValue, currentValue, res);
            }else{
                addOperatorsHelper(num, i+1, target, path+"+"+currentValue, value+currentValue, currentValue, res);
                addOperatorsHelper(num, i+1, target, path+"-"+currentValue, value-currentValue, -currentValue, res);
                addOperatorsHelper(num, i+1, target, path+"*"+currentValue, value-lastOptValue + lastOptValue*currentValue, lastOptValue*currentValue, res);
            }
        }
        return;
    }

    public static void main(String[] args){
        ExpressionAddOperators sol = new ExpressionAddOperators();
        String num = "105";
        int target = 5;
        System.out.println(sol.addOperators(num, target));
    }
}