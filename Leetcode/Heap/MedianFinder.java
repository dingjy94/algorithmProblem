/**
 * lc295 Find Median from Data Stream
 * two heap to store two half of all integers
 */
 
class MedianFinder {

    /** initialize your data structure here. */
    private class maxHeap implements Comparator<Integer> {
        @Override
        public int compare (Integer x, Integer y) {
            return y - x;
        }
    }
    PriorityQueue<Integer> minHalf;
    PriorityQueue<Integer> maxHalf;
    
    public MedianFinder() {
        minHalf = new PriorityQueue<>(10, new maxHeap());
        maxHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHalf.add(num);
        minHalf.add(maxHalf.poll());
        
        if (maxHalf.size() < minHalf.size()) {
            maxHalf.add(minHalf.poll());
        }
    }
    
    public double findMedian() {
        if (minHalf.size() == maxHalf.size()) {
            return (minHalf.peek() + maxHalf.peek()) / 2.0;
        } else {
            return maxHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
