import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        ArrayList<Integer> copyList = new ArrayList<>();

        Random rnd = new Random();
        Random rnd2 = new Random();

        for(int i=0; i<100; i++){
            int randomNumber = rnd.nextInt(100);
            numberList.add(randomNumber);
        }

        System.out.println("Random Numbers");
        for(int i : numberList){
            System.out.println(i);
        }
        System.out.println("**************");

        copyList.addAll(numberList);

        int randomNumber = rnd2.nextInt(100);

        System.out.println("Random Number: "+ randomNumber);

        ListIterator<Integer> listIterate = copyList.listIterator();
        while(listIterate.hasNext()){
            int j = listIterate.next();
            if(randomNumber == j){
                listIterate.remove();
                break;
            }
        }

        System.out.println("New Copy List:");
        for(int j : copyList){
            System.out.println(j);
        }

        int missingElement = compareLists(numberList, copyList);
        if(missingElement != -1){
            System.out.println("Missing Element: " + missingElement);
        }else{
            System.out.println("No missing element found!");

        }
    }
    public static int compareLists(ArrayList<Integer> numberList, ArrayList<Integer> copyList){

        Collections.sort(numberList);
        Collections.sort(copyList);

        int i = 0;
        int j = 0;

        while (i < numberList.size() && j < copyList.size()) {
            if (numberList.get(i).equals(copyList.get(j))) {
                i++;
                j++;
            } else {
                return numberList.get(i);
            }
        }
        return -1;
    }
}