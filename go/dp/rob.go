package dp

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
	var dp[] = [len(nums)]int
	dp[0] = nums[0]
	dp[1] = biger(nums[0], nums[1])
	for i := 2; i < len(nums); i++ {
		dp[i] = biger(dp[i - 1], dp[i - 2] + nums[i])
	}
	return dp[len(nums) - 1]
}

func biger(x, y int) int {
	if x > y {
		return x
	}
	return y
}