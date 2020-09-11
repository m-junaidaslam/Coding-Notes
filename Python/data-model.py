# Reference Link "https://docs.python.org/3/reference/datamodel.html"

# some behaviour that I want to implement -> write some __function__
# top-level function or top-level syntax -> corresponding __
#   x + y   ->  __add__
#   init x  ->  __init__
#   repr(x) ->  __repr__
#   x()     ->  __call__

class Polynomial:
    def __init__(self, *coeffs):
        self.coeffs = coeffs

    def __repr__(self):
        return 'Polynomial(*{!r})'.format(self.coeffs) # '!r' for __repr__


    def __add__(self, other):
        return Polynomial(*(x + y for x, y in zip(self.coeffs, other.coeffs)))

    def __len__(self):
        return len(self.coeffs)

    def __call__(self):
        pass


p1 = Polynomial(1, 2, 3) # x² + 2x + 3
p2 = Polynomial(1, 2, 3) # 3x² + 4x + 3
