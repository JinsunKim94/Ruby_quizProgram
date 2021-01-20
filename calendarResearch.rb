puts "누가 참여하는지 알려주세요!"
people = gets.chomp.split(" ")
#사용자가 입력한 것을 띄어쓰기 기준으로 배열 만들어준다.
puts "며칠간 설문을 할 지 알려주세요!"
days = gets.chomp.to_i
#사용자가 입력한 것은 다 문자라서 숫자로 받으려면 to_i로 변환한다.
meeting = {}#비어있는 해쉬
1.upto(days) do |day|
  #변환을 위한 days에는 무조건 숫자 들어가야함(그래서 변환한 것)
  meeting[day] = []
end

people.each do |person|
  1.upto(days) do |day|
    puts person + " 은/는 " + day.to_s + ") 날에 시간이 되면 Y/y를 누르세요."
    answer = gets.chomp

    if answer.downcase == "y"
    #downcase는 뭐든지 다 소문자로 만들겠다.
      meeting[day] << person
    end
  end
end

puts meeting.inspect
