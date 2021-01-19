pairs = {"한국"=>"seoul","베트남"=>"hanoi","미국"=>"washington"}
#무한루프
loop do
  pairs.each do |nation,capital|
    puts nation + "의 수도를 맞추세요."

    answer = gets.chomp

    if answer == capital
        puts "정답입니다."
        pairs.delete(nation)
    else
        puts "정답이 아닙니다. 정답은 : " + capital + "입니다."
    end
  end
  if pairs.size == 0
    break
  end
  puts "모든 질문이 끝났습니다. 오답을 묶어서 다시 시작합니다."
end

puts pairs
