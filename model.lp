max: i1A;

// Intersection 1
o1A = 0.25 i1B + 0.25 i1C + 0.25 i1D;
o1B = 0.5 i1A + 0.25 i1C + 0.25 i1D;
o1C = 0.25 i1A + 0.5 i1B + 0.5 i1D;
o1D = 0.25 i1A + 0.25 i1B + 0.5 i1C;

// Intersection 3
o3A = 0.25 i3B + 0.25 i3C + 0.25 i3D;
o3B = 0.5 i3A + 0.25 i3C + 0.25 i3D;
o3C = 0.25 i3A + 0.5 i3B + 0.5 i3D;
o3D = 0.25 i3A + 0.25 i3B + 0.5 i3C;

// Intersection 2
o2A = 0.25 i2B + 0.25 i2C + 0.25 i2D;
o2B = 0.5 i2A + 0.25 i2C + 0.25 i2D;
o2C = 0.25 i2A + 0.5 i2B + 0.5 i2D;
o2D = 0.25 i2A + 0.25 i2B + 0.5 i2C;

// Intersection 4
o4A = 0.25 i4B + 0.25 i4C + 0.25 i4D;
o4B = 0.5 i4A + 0.25 i4C + 0.25 i4D;
o4C = 0.25 i4A + 0.5 i4B + 0.5 i4D;
o4D = 0.25 i4A + 0.25 i4B + 0.5 i4C;





// connect intersections and add max flow
o1B = i3A;
o1B < 0.3;

o3A = i1B;
o3A < 0.3;

o1D = i2C;
o1D < 0.3;

o2C = i1D;
o2C < 0.3;

o4A = i2B;
o4A < 0.3;

o2B = i4A;
o2B < 0.3;

o4C = i3D;
o4C < 0.3;

o3D = i4C;
o3D < 0.3;

// Sources
i1A = 0.3 c;

c > 0; 


// set all szstem borders to 0
i1C = 0;

i2A = 0;
i2D = 0;

i3B = 0;
i3C = 0;

i4B = 0;
i4D = 0;

