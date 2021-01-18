

nation = "한국"
capital = "seoul"
puts nation + "의 수도를 맞추세요."
answer = gets.chomp
if capital==answer
    puts "정답입니다."
else
    puts "정답이 아닙니다."
end
