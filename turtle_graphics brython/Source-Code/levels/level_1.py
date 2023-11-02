tutorial_text = "Nutze eine for-Schleife um ein Hexagon zu zeichen!"
tutorial_code = "for x in range(n):\n\tprint(x, \", \")\n\nAusgabe: 0, 1, 2, ..., n,"
init_code = "from browser import document\nimport turtle\nturtle.set_defaults(turtle_canvas_wrapper = document['canvas'])\nt = turtle.Turtle()\n\nt.color('red')\nfor x in range(6):\n\tt.forward(100)\n\tt.right(60)\nturtle.done()"
written_code=""