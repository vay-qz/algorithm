package greedy

import "sort"

// 435
func eraseOverlapIntervals(intervals [][]int) int {
	if len(intervals) < 2 {
		return 0
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][1] < intervals[j][1]
	})
	sum := 0
	point := intervals[0][1]
	for i := 1; i < len(intervals); i++ {
		if point == intervals[i][1] {
			sum++
		} else if point <= intervals[i][0] {
			point = intervals[i][1]
		} else {
			sum++
		}
	}
	return sum
}
