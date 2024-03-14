import java.util.Map;
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) {
        String str =    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce iaculis pretium mauris quis placerat. Aenean luctus sagittis tortor quis molestie. Vestibulum auctor tincidunt ex in efficitur. Morbi odio quam, pharetra nec lacus ac, facilisis vulputate nunc. Nam nec dolor nunc. Quisque scelerisque arcu eget arcu fringilla mollis. Mauris euismod, tortor ac sagittis aliquam, erat lacus pharetra felis, a gravida augue lacus in elit. Vestibulum pulvinar tempus volutpat. Nam id mattis tortor. Vestibulum quam tellus, condimentum eu viverra in, finibus eget elit. Vivamus pretium dolor metus, laoreet bibendum leo facilisis id. Donec accumsan cursus varius. Donec nec purus at tortor elementum condimentum. Pellentesque nisl velit, varius vitae suscipit at, bibendum convallis felis. Proin pulvinar sapien eu pulvinar ullamcorper. Sed gravida ultricies enim, in hendrerit ex pharetra at. Nunc tempor efficitur mauris, nec lobortis ante rhoncus et. Aliquam erat volutpat. Donec eget varius leo. Integer blandit elit vel est porta porta. Aliquam non diam ligula. Fusce ante mi, mattis quis ornare vitae, varius a massa. Curabitur varius interdum malesuada. Etiam quis facilisis ex, eu eleifend arcu. Sed et sem vestibulum, eleifend mauris vel, laoreet purus. Ut auctor at arcu ac vulputate. Etiam at metus sapien. Phasellus nec nunc ullamcorper, aliquam tortor vel, tempor dolor. Sed nec mauris molestie, vehicula nibh non, faucibus libero. Duis facilisis mollis arcu, non varius felis consectetur non. Etiam non nisi lacus. Integer in neque dapibus, mollis enim lobortis, posuere est. Quisque eleifend lobortis arcu, vitae imperdiet tellus feugiat a. In eget iaculis erat, scelerisque ullamcorper neque. Integer blandit ultrices turpis, eu varius ipsum. Nam eu tempor diam. In hac habitasse platea dictumst. In iaculis sem id lacus iaculis rhoncus. Quisque vitae viverra diam, sit amet interdum augue. In eu ornare ipsum. Vestibulum cursus odio quis sapien vulputate porta. Mauris molestie pharetra nisi non eleifend. Nunc vel nisi sodales, condimentum ipsum vel, pulvinar sapien. Donec ultrices, ante et varius sodales, felis sem hendrerit felis, id mollis lectus libero nec mi. Cras tempus fermentum metus, sed faucibus orci sagittis ultrices. Nam scelerisque gravida interdum. Nulla facilisi. Sed eget nibh lorem. Duis finibus vitae dolor id interdum. Nam justo tortor, euismod quis sapien at, molestie mollis enim. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.";
        Map<String, Integer> wordMap = countWords(str);
        for (String key : wordMap.keySet()) {
            System.out.print(key + " " + wordMap.get(key) + "\n");
        }
    }
    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordMap = new TreeMap<String, Integer>();
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if ((input.charAt(i) >= 'a' && input.charAt(i) <= 'z') || (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                sb.append(input.charAt(i));
            } else {
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        addWord(wordMap, sb);
        return wordMap;
    }
    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }
}
