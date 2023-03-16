public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> deque = palindrome.wordToDeque(word);
        return isPalindromeHelp(deque);

        /*  Not recursion
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
        **/
    }

    public boolean isPalindromeHelp(Deque<Character> deque) {
        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }

        if (!deque.removeFirst().equals(deque.removeLast())) {
            return false;
        } else {
            return isPalindromeHelp(deque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome palindrome = new Palindrome();
        Deque<Character> deque = palindrome.wordToDeque(word);

        if (deque.size() == 0 || deque.size() == 1) {
            return true;
        }

        while (deque.size() > 1) {
            if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

}
