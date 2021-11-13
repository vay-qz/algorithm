package stringss

func DetectCapitalUse(word string) bool {
	return detectCapitalUse(word)
}

/**520 检测大写字母
我们定义，在以下情况时，单词的大写用法是正确的：
全部字母都是大写，比如 "USA" 。
单词中所有字母都不是大写，比如 "leetcode" 。
如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
*/
func detectCapitalUse(word string) bool {
	if len(word) < 2 {
		return true
	}
	if word[0] >= 'a' && word[0] <= 'z' {
		return judgeLow(word[1:])
	} else if word[1] >= 'a' && word[1] <= 'z' {
		return judgeLow(word[1:])
	} else {
		return judgeHigh(word[1:])
	}
}

func judgeHigh(s string) bool {
	for _, c := range s {
		if c >= 'a' && c <= 'z' {
			return false
		}
	}
	return true
}

func judgeLow(s string) bool {
	for _, c := range s {
		if c >= 'A' && c <= 'Z' {
			return false
		}
	}
	return true
}
