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

func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		if points[i][1] < points[j][1] {
			return true
		}
		return false
	})
	sum := 1
	maxpoint := points[0][1]
	for i := 1; i < len(points); i++ {
		if points[i][1] > maxpoint {
			sum++
			maxpoint = points[0][1]
		}
	}
	return sum
}

func lower(x ...int) int {
	min := x[0]
	for i := 1; i < len(x); i++ {
		if x[i] < min {
			min = x[i]
		}
	}
	return min
}

func isSubsequence(s string, t string) bool {
	if len(s) > len(t) {
		return false
	}
	si := 0
	for ti := 0; ti < len(t); ti++ {
		if s[si] == t[ti] {
			si++
			if si == len(s) {
				return true
			}
		}
	}
	return false
}

func findContentChildren(g []int, s []int) int {
	sort.Ints(g)
	sort.Ints(s)
	sum := 0
	j := 0
	for i := 0; i < len(g); i++ {
		for ; j < len(s); j++ {
			if s[j] >= g[i] {
				sum++
				j++
				break
			}
		}
	}
	return sum
}

func biger(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func PartitionLabels(s string) []int {
	return partitionLabels(s)
}

func partitionLabels(s string) []int {
	if len(s) == 1 {
		return []int{1}
	}
	res := []int{}
	begin := 0
	end := 0
	for i := 0; i < len(s); i++ {
		i2 := findEnd(s, s[i])
		end = biger(i2, end)
		if i == end {
			res = append(res, end-begin+1)
			begin = end + 1
		}
	}
	return res
}

func findEnd(s string, c uint8) int {
	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == c {
			return i
		}
	}
	return -1
}
