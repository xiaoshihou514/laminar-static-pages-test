# Additional toolchain support

Checkout full help by running `ndpc --help`

## Formatting

Run

```
ndpc format proof.ndp
```

The formatter is an uncompromising formatter, meaning that it will not respect what _you_ wrote, it will only format it in the way that it sees fit.

Example output:

```
forall x. ((forall y. (child(y, x) -> fly(y))) ^ dragon(x) -> happy(x))        [premise]
forall x. (green(x) ^ dragon(x) -> fly(x))                                     [premise]
forall x. ((exists y. (parent(y, x) ^ green(y))) -> green(x))                  [premise]
forall z. (forall x. (child(x, z) ^ dragon(z) -> dragon(x)))                   [premise]
forall x. (forall y. (child(y, x) -> parent(x, y)))                            [premise]
  c                                                                            [forall I const]
    dragon(c)                                                                  [ass]
      green(c)                                                                 [ass]
        d                                                                      [forall I const]
          child(d, c)                                                          [ass]
          forall y. (child(y, c) -> parent(c, y))                              [forallE(5)]
          parent(c, d)                                                         [forall->E(10, 11)]
          parent(c, d) ^ green(c)                                              [^I(12, 8)]
          exists y. (parent(y, d) ^ green(y))                                  [existsI(13)]
          green(d)                                                             [forall->E(14, 3)]
          child(d, c) ^ dragon(c)                                              [^I(10, 7)]
          forall x. (child(x, c) ^ dragon(c) -> dragon(x))                     [forallE(4)]
          dragon(d)                                                            [forall->E(16, 17)]
          green(d) ^ dragon(d)                                                 [^I(15, 18)]
          fly(d)                                                               [forall->E(19, 2)]
        child(d, c) -> fly(d)                                                  [->I(10, 20)]
      forall y. (child(y, c) -> fly(y))                                        [forallI(9, 21)]
      (forall y. (child(y, c) -> fly(y))) ^ dragon(c)                          [^I(22, 7)]
      happy(c)                                                                 [forall->E(23, 1)]
    green(c) -> happy(c)                                                       [->I(8, 24)]
  dragon(c) -> (green(c) -> happy(c))                                          [->I(7, 25)]
forall x. (dragon(x) -> (green(x) -> happy(x)))                                [forallI(6, 26)]



```

## Compiling to HTML

Run

```
ndpc proof.ndp
```

This will generate `proof.html`. You can do whatever you want with it :)

You can style it however you want by passing `--css [FILE]`. Read the generated HTML to see how is it done.

<a href="/ndpc/example_compile_out.html">Example output</a>

([you may have to reload if you see a 404](https://github.com/vuejs/vitepress/issues/4058))
