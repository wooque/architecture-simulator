ldb #200
stb r0
ldb #10
stb r2
jsr sum
halt
sum: beql lab
ldb r2
stb (r0)0
sub #1
stb r2
ldb r0
add #1
stb r0
ldb r2
jsr sum
ldb (r0)0
add r2
stb r2
lab: ldb r0
sub #1
stb r0
rts