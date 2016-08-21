package mitame.euler;
/*
  Problem 3: Largest prime factor

  The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143 ?
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Euler003 {
  public static List<Integer> generate_primes(int upto) {
    boolean[] is_not_prime = new boolean[upto];
    List<Integer> primes = new ArrayList<Integer>();

    for (int i = 2; i < upto; i++) {
      if (!is_not_prime[i]) {
        for (int j = 1; (j * i) < upto; j++) {
          is_not_prime[j * i] = true;
        }
        primes.add(i);
      }
    }
    return primes;
  }
  public static void main(String[] args) {
    long n = 600851475143L;
    Double root_n = Double.valueOf(Math.sqrt(n));
    List<Integer> primes = generate_primes(root_n.intValue());
    Integer max_prime = 0;
    for (Integer p: primes) {
      if (n % p == 0)
        max_prime = p;
    }

    System.out.println(max_prime);
  }
}
