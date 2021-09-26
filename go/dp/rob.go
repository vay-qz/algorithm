package dp

import "sort"

func Rob(nums []int) int {
	return rob(nums)
}

func rob(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	if len(nums) == 2 {
		return biger(nums[0], nums[1])
	}
	return biger(doRob(nums[:len(nums)-1]), doRob(nums[1:]))
}

func doRob(nums []int) int {
	var dp = make([]int, len(nums))
	dp[0] = nums[0]
	dp[1] = biger(nums[0], nums[1])
	for i := 2; i < len(nums); i++ {
		dp[i] = biger(dp[i-1], dp[i-2]+nums[i])
	}
	return dp[len(nums)-1]
}

func MinPathSum(grid [][]int) int {
	return minPathSum(grid)
}

func minPathSum(grid [][]int) int {
	var m = len(grid)
	var n = len(grid[0])
	var dp = make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	dp[0][0] = grid[0][0]
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if j == 0 && i == 0 {
				continue
			}
			if j == 0 {
				dp[i][j] = dp[i-1][j] + grid[i][j]
				continue
			}
			if i == 0 {
				dp[i][j] = dp[i][j-1] + grid[i][j]
				continue
			}
			dp[i][j] = smaller(dp[i-1][j], dp[i][j-1]) + grid[i][j]
		}
	}
	return dp[m-1][n-1]
}

func smaller(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func UniquePaths(m int, n int) int {
	return uniquePaths(m, n)
}

func uniquePaths(m int, n int) int {
	if m == 1 || n == 1 {
		return 1
	}
	var dp = make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		dp[i][0] = 1
	}
	for i := 0; i < n; i++ {
		dp[0][i] = 1
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[m-1][n-1]
}

func NumberOfArithmeticSlices(nums []int) int {
	return numberOfArithmeticSlices(nums)
}

func numberOfArithmeticSlices(nums []int) int {
	if len(nums) < 3 {
		return 0
	}
	var dp = make([]int, len(nums)-1)
	for i := 0; i < len(nums)-1; i++ {
		dp[i] = nums[i+1] - nums[i]
	}
	sum := 0
	i := 0
	j := 1
	for j < len(dp) {
		if dp[i] == dp[j] {
			for j < len(dp)-1 {
				if dp[j] == dp[j+1] {
					j++
				} else {
					break
				}
			}
			n := j - i + 1
			sum += n * (n - 1) / 2
			i = j + 1
			j = i + 1
		} else {
			i++
			j++
		}
	}
	return sum
}

func IntegerBreak(n int) int {
	return integerBreak(n)
}

func integerBreak(n int) int {
	if n == 2 || n == 3 {
		return n - 1
	}
	r := n / 3
	y := n % 3
	if y == 0 {
		res := 1
		for i := 0; i < r; i++ {
			res *= 3
		}
		return res
	}
	if y == 1 {
		res := 4
		for i := 0; i < r-1; i++ {
			res *= 3
		}
		return res
	}
	res := 2
	for i := 0; i < r; i++ {
		res *= 3
	}
	return res
}

func NumSquares(n int) int {
	return numSquares(n)
}

func numSquares(n int) int {
	if n < 4 {
		return n
	}
	var dp = make([]int, n+1)
	dp[1] = 1
	for i := 2; i < n+1; i++ {
		var min = 100000
		for j := 1; j <= (i+1)/2; j++ {
			if j*j == i {
				min = 1
				break
			}
			if dp[j]+dp[i-j] < min {
				min = dp[j] + dp[i-j]
			}
		}
		dp[i] = min
	}
	return dp[n]
}

func NumDecodings(s string) int {
	return numDecodings(s)
}

func numDecodings(s string) int {
	if s[0] == '0' {
		return 0
	}
	var dp = make([]int, len(s))
	dp[0] = 1
	for i := 1; i < len(s); i++ {
		if s[i] == '0' {
			if s[i-1] == '1' || s[i-1] == '2' {
				if i == 1 {
					dp[i] = 1
				} else {
					dp[i] = dp[i-2]
				}
			} else {
				return 0
			}
		}
		if s[i] >= '1' && s[i] <= '6' {
			if s[i-1] == '1' || s[i-1] == '2' {
				if i == 1 {
					dp[i] = 2
				} else {
					dp[i] = dp[i-1] + dp[i-2]
				}
			} else {
				dp[i] = dp[i-1]
			}
		}
		if s[i] > '6' {
			if s[i-1] == '1' {
				if i == 1 {
					dp[i] = 2
				} else {
					dp[i] = dp[i-1] + dp[i-2]
				}
			} else {
				dp[i] = dp[i-1]
			}
		}
	}
	return dp[len(s)-1]
}

func LengthOfLIS(nums []int) int {
	return lengthOfLIS(nums)
}

func lengthOfLIS(nums []int) int {
	if len(nums) == 1 {
		return 1
	}
	dp := make([]int, len(nums))
	dp[0] = 1
	for i := 1; i < len(nums); i++ {
		dp[i] = 1
		for j := 0; j < len(nums); j++ {
			if nums[j] < nums[i] {
				dp[i] = biger(dp[j]+1, dp[i])
			}
		}
	}
	var max int
	for i := 0; i < len(nums); i++ {
		if max < dp[i] {
			max = dp[i]
		}
	}
	return max
}

func biger(x, y int) int {
	if x > y {
		return x
	}
	return y
}

func FindLongestChain(pairs [][]int) int {
	return findLongestChain(pairs)
}

func findLongestChain(pairs [][]int) int {
	sort.Slice(pairs, func(i, j int) bool {
		if pairs[i][0] < pairs[j][0] {
			return true
		}
		return false
	})
	if len(pairs) == 1 {
		return 1
	}
	dp := make([]int, len(pairs))
	dp[0] = 1
	for i := 1; i < len(pairs); i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if pairs[j][1] < pairs[i][0] && dp[i] < dp[j]+1 {
				dp[i] = dp[j] + 1
			}
		}
	}
	max := 0
	for i := 0; i < len(pairs); i++ {
		if max < dp[i] {
			max = dp[i]
		}
	}
	return max
}
