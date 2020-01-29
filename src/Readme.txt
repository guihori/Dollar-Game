Equation for dollar game

given two pairs of points forming two distinct lines. Find where those lines meet
(x1,y1) (x2,y2) (x3,y3) (x4,y4)
y = mx + b
(y2 - y1) = m1(x2 - x1)			(y4 - y3) = m3(x4 - x3)
m1 = (y2 - y1)/(x2 - x1)		m3 = (y4 - y3)/(x4 - x3)
(y - y1) = m1(x - x1)			(y - y3) = m3(x - x3)
y = m1(x - x1) + y1			y = m3(x - x3) + y3
m1(x - x1) + y1 = m3(x - x3) + y3
m1x - m1x1 + y1 = m3x - m3x3 + y3
m1x - m3x = m1x1 - y1 - m3x3 + y3
x(m1 - m3)
x = (m1x1 - y1 - m3x3 + y3)/(m1 -m3)
x = (((y2 - y1)/(x2 - x1))x1 - y1 - ((y4 - y3)/(x4 - x3))x3 + y3)/((y2 - y1)/(x2 - x1) - (y4 - y3)/(x4 - x3))

given a pair of points that form a line and a point find where a perpendicular line passing through this rogue point intersect
AKA find the distance of a point from a line

(x1,y1) (x3,y3) (x4,y4)		-m1^-1 = m3

(y - y1) = m1(x - x1)			(y4 - y3) = m3(x4 - x3)
(y - y1) = -(x - x1)/m3			m3 = (y4 - y3)/(x4 - x3)
					(y - y3) = m3(x - x3)
y = -(x - x1)/m3 + y1			y = m3(x - x3) + y3
-(x - x1)/m3 + y1 = m3(x - x3) + y3
-x/m3 + x1/m3 + y1 = m3x - m3x3 + y3
-x/m3 - m3x = - x1/m3 - y1 - m3x3 + y3
-x (1/m3 + m3) =
-x = ( - x1/m3 - y1 - m3x3 + y3)/(1/m3 +m3)
x = -(-x1/((y4 - y3)/(x4 - x3)) - y1 - ((y4 - y3)/(x4 - x3))*x3 + y3)/(1/((y4 - y3)/(x4 - x3)) + (y4 - y3)/(x4 - x3))

y = -((-(-x1/((y4 - y3)/(x4 - x3)) - y1 - ((y4 - y3)/(x4 - x3))*x3 + y3)/(1/((y4 - y3)/(x4 - x3)) + (y4 - y3)/(x4 - x3))) - x1)/((y4 - y3)/(x4 - x3)) + y1

find the shortest distance between a point(x1,y1) and a line(x3,y3),(x4,y4)
(x1,y1) (x3,y3) (x4,y4)

sqrt(x1-(-(-x1/((y4 - y3)/(x4 - x3)) - y1 - ((y4 - y3)/(x4 - x3))*x3 + y3)/(1/((y4 - y3)/(x4 - x3)) + (y4 - y3)/(x4 - x3))))^2 + (y1-(-((-(-x1/((y4 - y3)/(x4 - x3)) - y1 - ((y4 - y3)/(x4 - x3))*x3 + y3)/(1/((y4 - y3)/(x4 - x3)) + (y4 - y3)/(x4 - x3))) - x1)/((y4 - y3)/(x4 - x3)) + y1))^2)
sqrt(x1-(-(-x1/m3 - y1 - m3*x3 + y3)/(1/m3 + m3)))^2 + (y1-(-((-(-x1/m3 - y1 -m3*x3 + y3)/(1/m3 + m3)) - x1)/m3 + y1))^2)