/* all primes are of the form 6k ± 1, with the exception of 2 and 3. 
 * This is because all integers can be expressed as (6k + i) for some integer k and 
 * for i = ?1, 0, 1, 2, 3, or 4; 2 divides (6k + 0), (6k + 2), (6k + 4); 
 * and 3 divides (6k + 3). So a more efficient method is to test if n is divisible by 2 or 3, 
 * then to check through all the numbers of form 6k ± 1
 */

function isPrime(num) {
  if (num <= 1) return false;
  if (num <= 3) return true;
  
  if (num % 2 === 0 || num % 3 === 0) {
    return false;
  }
  
  for (let i = 5; i * i <= num; i += 6) {
    if (num % i === 0 || num % (i + 2) === 0) {
      return false;
    }
  }
  
  return true;
}
