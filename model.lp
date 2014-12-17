max: i1A;

// Intersection 1
o1A = 0.25 i1B + 0.25 i1C + 0.25 i1D;
o1B = 0.5 i1A + 0.25 i1C + 0.25 i1D;
o1C = 0.25 i1A + 0.5 i1B + 0.5 i1D;
o1D = 0.25 i1A + 0.25 i1B + 0.5 i1C;

// Intersection 4
o4A = 0.25 i4B + 0.25 i4C + 0.25 i4D;
o4B = 0.5 i4A + 0.25 i4C + 0.25 i4D;
o4C = 0.25 i4A + 0.5 i4B + 0.5 i4D;
o4D = 0.25 i4A + 0.25 i4B + 0.5 i4C;

// Intersection 7
o7A = 0.25 i7B + 0.25 i7C + 0.25 i7D;
o7B = 0.5 i7A + 0.25 i7C + 0.25 i7D;
o7C = 0.25 i7A + 0.5 i7B + 0.5 i7D;
o7D = 0.25 i7A + 0.25 i7B + 0.5 i7C;

// Intersection 2
o2A = 0.25 i2B + 0.25 i2C + 0.25 i2D;
o2B = 0.5 i2A + 0.25 i2C + 0.25 i2D;
o2C = 0.25 i2A + 0.5 i2B + 0.5 i2D;
o2D = 0.25 i2A + 0.25 i2B + 0.5 i2C;

// Intersection 5
o5A = 0.25 i5B + 0.25 i5C + 0.25 i5D;
o5B = 0.5 i5A + 0.25 i5C + 0.25 i5D;
o5C = 0.25 i5A + 0.5 i5B + 0.5 i5D;
o5D = 0.25 i5A + 0.25 i5B + 0.5 i5C;

// Intersection 8
o8A = 0.25 i8B + 0.25 i8C + 0.25 i8D;
o8B = 0.5 i8A + 0.25 i8C + 0.25 i8D;
o8C = 0.25 i8A + 0.5 i8B + 0.5 i8D;
o8D = 0.25 i8A + 0.25 i8B + 0.5 i8C;

// Intersection 3
o3A = 0.25 i3B + 0.25 i3C + 0.25 i3D;
o3B = 0.5 i3A + 0.25 i3C + 0.25 i3D;
o3C = 0.25 i3A + 0.5 i3B + 0.5 i3D;
o3D = 0.25 i3A + 0.25 i3B + 0.5 i3C;

// Intersection 6
o6A = 0.25 i6B + 0.25 i6C + 0.25 i6D;
o6B = 0.5 i6A + 0.25 i6C + 0.25 i6D;
o6C = 0.25 i6A + 0.5 i6B + 0.5 i6D;
o6D = 0.25 i6A + 0.25 i6B + 0.5 i6C;

// Intersection 9
o9A = 0.25 i9B + 0.25 i9C + 0.25 i9D;
o9B = 0.5 i9A + 0.25 i9C + 0.25 i9D;
o9C = 0.25 i9A + 0.5 i9B + 0.5 i9D;
o9D = 0.25 i9A + 0.25 i9B + 0.5 i9C;





// connect intersections and add max flow
o1B = i4A;
o1B < 0.3;

o4A = i1B;
o4A < 0.3;

o1D = i2C;
o1D < 0.3;

o2C = i1D;
o2C < 0.3;

o9A = i6B;
o9A < 0.3;

o6B = i9A;
o6B < 0.3;

o9C = i8D;
o9C < 0.3;

o8D = i9C;
o8D < 0.3;

// Sources
i1A = 0.3 c;

c > 0; 


// set all szstem borders to 0
i1C = 0;

i2A = 0;
i2B = 0;
i2D = 0;

i3A = 0;
i3B = 0;
i3C = 0;
i3D = 0;

i4B = 0;
i4C = 0;
i4D = 0;

i5A = 0;
i5B = 0;
i5C = 0;
i5D = 0;

i6A = 0;
i6C = 0;
i6D = 0;

i7A = 0;
i7B = 0;
i7C = 0;
i7D = 0;

i8A = 0;
i8B = 0;
i8C = 0;

i9B = 0;
i9D = 0;

