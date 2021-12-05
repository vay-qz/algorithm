package greedy

import "sort"

func FindContentChildren(g []int, s []int) int {
	return findContentChildren(g, s)
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

func EraseOverlapIntervals(intervals [][]int) int {
	return eraseOverlapIntervals(intervals)
}

func eraseOverlapIntervals(intervals [][]int) int {
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] > intervals[j][0]
	})
	sum := 0
	head := intervals[0][0]
	tail := intervals[0][1]
	for i := 0; i < len(intervals); {
		j := i + 1
		for ; j < len(intervals); j++ {
			if head == intervals[j][0] {
				tail = lower(intervals[j][0], intervals[i][0])
				sum++
			} else {
				break
			}
		}
		i = j
		head = tail
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
