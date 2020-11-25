+ [Insert Interval](#insert-interval)
+ [Merge Intervals](#merge-intervals)

## Insert Interval

https://leetcode.com/problems/insert-interval/

```java
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    while(i<intervals.length && intervals[i][1] < newInterval[0]){
        result.add(intervals[i]); // or result.add(intervals[i++]);
        i++;
    }
    
    while(i<intervals.length && intervals[i][0] <= newInterval[1]){
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        i++;
    }
    
    result.add(newInterval);
    while(i<intervals.length){
        result.add(intervals[i++]);
    }
    return result.toArray(new int[result.size()][2]);
}     
```

## Merge Intervals

https://leetcode.com/problems/merge-intervals/

```java
// отдельно сделаем сортировку
private class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
    }
}

public int[][] merge(int[][] intervals) {
    if(intervals == null)
        return intervals;
    LinkedList<int[]> newintervals = new LinkedList<>();//создание связанного списка
    Collections.sort(Arrays.asList(intervals), new IntervalComparator());
    //intervals.sort(key = lambda x: x[0])
    
    for (int[] interval : intervals){ //interval in intervals
        if (newintervals.isEmpty() || newintervals.getLast()[1] < interval[0])
            newintervals.add(interval);
        else if (interval[1] >= newintervals.getLast()[1])
            newintervals.getLast()[1] = interval[1];
    }
    return newintervals.toArray(new int[newintervals.size()][]);
}
```