package dp

type NumArray struct {
	dp []int
}

func Constructor(nums []int) NumArray {
	var dp = make([]int, len(nums))
	dp[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		dp[i] = dp[i-1] + nums[i]
	}
	return NumArray{dp}
}

func (this *NumArray) SumRange(left int, right int) int {
	if left == 0 {
		return this.dp[right]
	}
	return this.dp[right] - this.dp[left-1]
}
